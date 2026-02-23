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
17            if(i > 0 && nums[i] == nums[i-1] && added[i-1]){
18                continue;
19            }
20
21            per.add(nums[i]);
22            added[i] = true;
23
24            permuteUnique(nums, ans, added, per);
25
26            per.remove(per.size() - 1);
27            added[i] = false;
28        }
29
30    }
31
32    public List<List<Integer>> permuteUnique(int[] nums) {
33        
34        int n = nums.length;
35        Arrays.sort(nums);
36        Set<List<Integer>> ans = new HashSet<>();
37        boolean[] added  = new boolean[n];
38        List<Integer> per = new ArrayList<>();
39
40        permuteUnique(nums, ans, added, per);
41
42        return new ArrayList<>(ans);
43    }
44}