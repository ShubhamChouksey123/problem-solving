1class Solution {
2
3    private void permuteUnique(int[] nums, Set<List<Integer>> ans, boolean[] added, List<Integer> per){
4
5        if(per.size() == nums.length){
6            ans.add(new ArrayList<>(per)); return;
7        }
8
9        
10
11        for(int i = 0 ; i < nums.length ; i++){
12
13            if(added[i] == true){
14                continue;
15            }
16
17            per.add(nums[i]);
18            added[i] = true;
19
20            permuteUnique(nums, ans, added, per);
21
22            per.remove(per.size() - 1);
23            added[i] = false;
24        }
25
26    }
27
28    public List<List<Integer>> permuteUnique(int[] nums) {
29        
30        int n = nums.length;
31        Set<List<Integer>> ans = new HashSet<>();
32        boolean[] added  = new boolean[n];
33        List<Integer> per = new ArrayList<>();
34
35        permuteUnique(nums, ans, added, per);
36
37        return new ArrayList<>(ans);
38    }
39}