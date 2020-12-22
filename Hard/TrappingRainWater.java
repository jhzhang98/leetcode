package Hard;

public class TrappingRainWater {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int curHeight = 0;
        int water = 0;
        while (l < r) {
            curHeight = Math.max(Math.min(height[r], height[l]), curHeight);
            if (height[l] <= curHeight)
                water += curHeight - height[l];
            if (height[r] <= curHeight)
                water += curHeight - height[r];

            if (height[r] < height[l]) {
                r--;
            } else {
                l++;
            }

        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater water = new TrappingRainWater();
        int[] height = {4,2,0,3,2,5};
        System.out.println(water.trap(height));
    }
}
