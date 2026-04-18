class Solution {

    public void backtrack(int[] nums, int index, int curSum, int target, List<Integer> comb, List<List<Integer>> combinations) {

        if (curSum > target || index >= nums.length) {
            return;
        }

        if (curSum == target) {
            combinations.add(new ArrayList<>(comb));
            return;
        }

        comb.add(nums[index]);
        backtrack(nums, index, curSum + nums[index], target, comb, combinations);
        comb.remove(comb.size() - 1);
        
        backtrack(nums, index + 1, curSum, target, comb, combinations);

        return;
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(nums, 0, 0, target, new ArrayList(), combinations);
        return combinations;
    }
}