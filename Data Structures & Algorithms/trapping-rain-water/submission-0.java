class Solution {
    public int trap(int[] height) {

        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j + 1]);
        }

        int sumWater = 0;

        for (int i = 1; i < n - 1; i++) {
            sumWater += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return sumWater;
    }
}
