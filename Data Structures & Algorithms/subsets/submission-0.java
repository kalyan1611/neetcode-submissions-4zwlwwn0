class Solution {

    public void subsets(int[] nums, int cur, List<List<Integer>> ans) {
        for (int i = cur; i < nums.length; i++) {
            List<List<Integer>> ans1 = new ArrayList();
            for (List<Integer> l : ans) {
                List<Integer> newL = new ArrayList<>(l);
                newL.add(nums[i]);
                ans1.add(newL);
            }
            ans.addAll(ans1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        subsets(nums, 0, ans);
        return ans;
    }
}
