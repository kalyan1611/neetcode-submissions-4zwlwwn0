class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int low = 0;
        int high = n - 1;

        while (low < high) {

            int mid = (low + high)/2;
            if (nums[low] <= nums[high]) {
                return nums[low];
            } else {
                if (nums[low] > nums[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return nums[low];
    }
}
