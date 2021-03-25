package Medium;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Stack;

public class Match132Pattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        int[] minArrayLeft = new int[nums.length];
        minArrayLeft[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            minArrayLeft[i] = Math.min(nums[i], minArrayLeft[i - 1]);
        int[] minArrayRight = new int[nums.length];
        minArrayRight[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--)
            minArrayRight[i] = Math.min(nums[i], minArrayRight[i + 1]);

        int index = 1;
        while (index < nums.length) {
            if (nums[index] > minArrayLeft[index]) {
                while (index < nums.length) {
                    if (nums[index] > minArrayRight[index] && minArrayRight[index] > minArrayLeft[index])
                        return true;
                    index++;
                }
            } else {
                index++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 0, 3, 4};
        System.out.println(new Match132Pattern().find132pattern(nums));
    }
}
