1class Solution {
2
3    private void combinationSumUtil(int[] candidates, List<List<Integer>> result, int target, int sum, int start, List<Integer> com){
4    
5        if(sum > target){
6            return;
7        }
8
9        if(sum == target){
10            result.add(new ArrayList<>(com));
11            return;
12        }
13
14        for(int i = start ; i < candidates.length ; i++){
15
16            if(sum + candidates[i] <= target){
17                com.add(candidates[i]);
18                combinationSumUtil(candidates, result, target, sum + candidates[i], i, com);
19
20                com.remove(com.size() - 1);
21            }
22        }        
23    }
24
25    public List<List<Integer>> combinationSum(int[] candidates, int target) {
26
27        List<List<Integer>> result = new ArrayList<>();
28
29        combinationSumUtil(candidates, result, target, 0, 0, new ArrayList<>());
30        return result;
31    }
32}