class Solution {
    private void combinationSumUtil(int[] candidates, int target, List<List<Integer>> ans, int sum, int startIndex, List<Integer> list) {

        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSumUtil(candidates, target, ans, sum + candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        combinationSumUtil(candidates, target, ans, 0, 0, new ArrayList<>());
        return ans;
    }
}