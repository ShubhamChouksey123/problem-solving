class Solution {

    private List<List<Integer>> ans ;

    private void combinationSum2Util(int[] candidates, int target, int sum, int start, List<Integer> arr){

        if(sum == target){
            ans.add(new ArrayList(arr));
            return ;
        }

        for(int i = start ; i < candidates.length ; i++){

            if( i > start && candidates[i-1] == candidates[i]){
                continue;
            }

            if(target - sum >= candidates[i]){
                arr.add(candidates[i]);
                combinationSum2Util(candidates, target, sum + candidates[i], i + 1, arr);
                arr.remove(arr.size() - 1);
            }else{
                break;
            } 
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        combinationSum2Util(candidates, target, 0, 0, new ArrayList<>());
        
        return ans;
    }
}