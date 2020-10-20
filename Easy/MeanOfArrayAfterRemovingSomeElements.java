package Easy;

import java.util.Arrays;

public class MeanOfArrayAfterRemovingSomeElements {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int del = arr.length * 5 / 100;
        int start = del, end = arr.length - del;
        int sum = 0;
        for (int i=start ; i<end ; i++){
            sum += arr[i];
        }
        return sum* 1.0 / (arr.length - del - del);
    }
}