1class Solution {
2    
3    private void permute(int[] nums, List<List<Integer>> ans, boolean[] added, List<Integer> curr) {
4
5        if(curr.size() == nums.length){
6            ans.add(new ArrayList<>(curr));
7            return;
8        }
9
10        for(int i = 0 ; i < nums.length ; i++){
11            if(added[i]) continue;
12
13            curr.add(nums[i]);
14            added[i] = true;
15            permute(nums, ans, added, curr);
16
17            added[i] = false;
18            curr.remove(curr.size() - 1);
19        }
20    }
21    
22    public List<List<Integer>> permute(int[] nums) {
23
24        int n = nums.length;
25        boolean[] added = new boolean[n+1];
26        List<List<Integer>> ans = new ArrayList<>();
27
28        permute(nums, ans, added, new ArrayList<>()); 
29        return ans;
30    }
31}