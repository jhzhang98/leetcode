package Medium;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int oneCount = 0, maxNum = 0;
        int left = 0, right = -1;

        while (++right < A.length) {
            if (A[right] == 1) oneCount++;
            if (right - left + 1 - oneCount > K) {
                if (A[left] == 1) oneCount--;
                left++;
            }
            maxNum = Math.max(maxNum, right - left);
        }
        return Math.max(maxNum, right - left);
    }

    public static void main(String[] args) {
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        int K = 2;
        System.out.println(new MaxConsecutiveOnesIII().longestOnes(A, K));
    }
}
