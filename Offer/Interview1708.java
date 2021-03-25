package Offer;

import java.util.*;

public class Interview1708 {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int[][] person = new int[height.length][2];
        for (int i = 0; i < height.length; i++) person[i] = new int[]{height[i], weight[i]};
        Arrays.sort(person, (o1, o2) -> {
            if (o1[0] < o2[0]) return -1;
            else if (o1[0] > o2[0]) return 1;
            else return Integer.compare(o2[1], o1[1]);
        });
        int[] sortedWeight = new int[height.length];
        for (int i = 0; i < height.length; i++)
            sortedWeight[i] = person[i][1];

        return ascendingSeq(sortedWeight);
    }

    private int ascendingSeq(int[] data) {
        if (data.length == 0) return 0;
        int maxLen = 1;
        int end = 0;
        int[] sortedData = new int[data.length];
        sortedData[0] = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > sortedData[end]) {
                sortedData[end + 1] = data[i];
                end++;
                maxLen = Math.max(maxLen, end + 1);
            } else {
                if (sortedData[0] >= data[i]) {
                    sortedData[0] = data[i];
                    continue;
                }
                // 二分查找第一个小于它的值，替换它右侧的值
                int l = 0, r = end;
                int index = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (sortedData[mid] == data[i]) {
                        index = mid;
                        break;
                    } else if (sortedData[mid] > data[i]) {
                        r = mid - 1;
                    } else {
                        index = mid + 1;
                        l = mid + 1;
                    }
                }
                sortedData[index] = data[i];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] height = {65, 70, 56, 75, 60, 68, 23, 44, 66, 11, 78};
        int[] weight = {100, 150, 90, 89, 95, 110, 78, 33, 99, 100, 76};
        System.out.println(new Interview1708().bestSeqAtIndex(height, weight));
    }
}
