class Solution {
    public int maxArea(int[] heights) {
        
        int n = heights.length;

        int left = 0;
        int right = n - 1;
        int maxWater = 0;

        while (left < right) {
            maxWater = Math.max(maxWater, (right - left)*Math.min(heights[left], heights[right]));
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
