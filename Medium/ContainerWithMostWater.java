package Medium;

public class ContainerWithMostWater {
    // 暴力做法 O(n²)
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++) {
                int tmpArea = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(tmpArea, maxArea);
            }
        return maxArea;
    }

    // 指针做法
    public int maxArea2(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int currentArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(currentArea, maxArea);
            if (height[left] < height[right])
                left += 1;
            else
                right -= 1;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cwm = new ContainerWithMostWater();
        int[] height = {};
        System.out.println(cwm.maxArea2(height));
    }
}
