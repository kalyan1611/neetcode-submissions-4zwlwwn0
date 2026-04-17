class Solution {

    public void backtrack(int[] nums, int cur, List<Integer> subsets, List<List<Integer>> ans) {
        if (cur >= nums.length) {
            ans.add(new ArrayList<>(subsets));
            return;
        }

        subsets.add(nums[cur]);
        backtrack(nums, cur + 1, subsets, ans);
        subsets.remove(subsets.size() - 1);
        backtrack(nums, cur + 1, subsets, ans);
    }
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subsets = new ArrayList<>();

        backtrack(nums, 0, subsets, ans);

        return ans;
    }
}
