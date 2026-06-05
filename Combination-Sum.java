1class Solution {
2    
3    private void combinationSum(int[] candidates, int target, List<List<Integer>> ans, List<Integer> cur, int sum, int index) {
4        
5        if(sum == target){
6            ans.add(new ArrayList<>(cur));
7            return;
8        }
9        else if(sum > target){
10            return;
11        }
12
13        for(int i = index; i < candidates.length; i++){
14            sum += candidates[i];
15            cur.add(candidates[i]);
16
17            combinationSum(candidates, target, ans, cur, sum, i);
18
19            sum -= candidates[i];
20            cur.remove(cur.size() - 1);
21        }
22    }
23
24    public List<List<Integer>> combinationSum(int[] candidates, int target) {
25
26        Arrays.sort(candidates);
27        List<List<Integer>> ans = new ArrayList<>();
28        combinationSum(candidates, target, ans, new ArrayList<>(), 0, 0);
29        return ans;
30    }
31}