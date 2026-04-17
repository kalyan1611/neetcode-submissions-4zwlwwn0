class Solution {

    public void subsets(int[] nums, int cur, List<List<Integer>> ans) {
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> ans1 = new ArrayList();
            for (List<Integer> l : ans) {
                List<Integer> newL = new ArrayList<>(l);
                newL.add(nums[i]);
                ans1.add(newL);
            }
            ans.addAll(ans1);
        }
        return ans;
    }
}
