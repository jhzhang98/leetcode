package Hard;

import java.util.Arrays;
import java.util.Stack;

public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        Stack<Integer> stack = new Stack<>();
        int del = nums1.length + nums2.length - k;
        int curDel = 0;

        int p1 = 0, p2 = 0;
        while(p1 < nums1.length || p2 < nums2.length){
            int next = -1;
            if (p2 == nums2.length){
                next = nums1[p1++];
            }else if (p1 == nums1.length){
                next = nums2[p2++];
            }else if (nums1[p1] > nums2[p2]){
                next = nums1[p1++];
            }else{
                next = nums2[p2++];
            }
            while(!stack.isEmpty() && next > stack.peek() && curDel < del){
                stack.pop();
                curDel++;
            }
            stack.add(next);
        }
        while(curDel != del){
            stack.pop();
            curDel++;
        }

        int[] res = new int[k];
        int index = k - 1;
        while(!stack.isEmpty()){
            res[index--] = stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        CreateMaximumNumber number = new CreateMaximumNumber();
        int[] nums1 = {3,4,6,5};
        int[] nums2 = {9,1,2,5,8,3};
        int k = 5;
        System.out.println(Arrays.toString(number.maxNumber(nums1, nums2, k)));
    }
}
