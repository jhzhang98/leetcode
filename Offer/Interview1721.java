package Offer;

public class Interview1721 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int curHeight = 0;
        int res = 0;
        while (left < right) {
            curHeight = Math.max(curHeight, Math.min(height[left], height[right]));
            if (curHeight > height[left]) res += curHeight - height[left];
            if (curHeight > height[right]) res += curHeight - height[right];
            if (height[left] < height[right]) left++;
            else right--;
        }
        return res;
    }
}
