class Solution {
    private void subsets(int[] nums, List<List<Integer>> ans, int index, int n, List<Integer> st) {

        if (index == n) {
            ans.add(new ArrayList<>(st));
            return;
        }

        subsets(nums, ans, index + 1, n, st);

        st.add(nums[index]);
        subsets(nums, ans, index + 1, n, st);

        st.remove(st.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        subsets(nums, ans, 0, nums.length, new ArrayList<>());
        return ans;
    }
}