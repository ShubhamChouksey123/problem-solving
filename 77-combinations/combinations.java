class Solution {
    public void combineUtils(int n, int k, int index, int start, List<Integer> combination, List<List<Integer>> ans) {

        if (index == k) {
            if (combination.size() == k) {
                ans.add(new ArrayList<>(combination));
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            combination.add(i);
            combineUtils(n, k, index + 1, i + 1, combination, ans);
            combination.remove(combination.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        combineUtils(n, k, 0, 1, new ArrayList<>(), ans);

        return ans;
    }
}