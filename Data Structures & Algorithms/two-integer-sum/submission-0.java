class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            if (cache.containsKey(target - nums[i])) {
                return new int[]{cache.get(target - nums[i]), i};
            }
            cache.put(nums[i], i);
        }
        return new int[]{};
    }
}
