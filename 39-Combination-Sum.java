class Solution {
    
    public void combinationSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> cur, int sum, int index) {
        
        if(sum > target) return;
        if(target == sum){
            result.add(new ArrayList<>(cur)); return;
        }
        for(int i = index ; i < candidates.length ; i++){
            cur.add(candidates[i]);
            combinationSum(candidates, target, result, cur, sum + candidates[i], i);
            cur.remove(cur.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        int n = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, result, new ArrayList<>(), 0, 0);
        return result;
    }
}