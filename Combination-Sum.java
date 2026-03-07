1class Solution {
2    public void combinationSum(int[] candidates, int target, int sum, int start, List<Integer> cur, List<List<Integer>> result) {
3        if(sum > target){
4            return;
5        }
6
7        if(sum == target){
8            result.add(new ArrayList<>(cur)); return;
9        }
10
11        for(int i = start ; i < candidates.length ; i++){
12            int candidate = candidates[i];
13
14            cur.add(candidate);
15            combinationSum(candidates, target, sum + candidate, i, cur, result);
16
17            cur.remove(cur.size() - 1);
18        }
19        
20
21    }
22    
23    public List<List<Integer>> combinationSum(int[] candidates, int target) {
24
25        Arrays.sort(candidates);
26
27        List<List<Integer>> result = new ArrayList<>();
28        combinationSum(candidates, target, 0, 0, new ArrayList<>(), result);
29        
30        return result;
31    }
32}