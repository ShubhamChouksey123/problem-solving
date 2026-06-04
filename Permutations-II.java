1class Solution {
2    
3    private void permuteUnique(int[] nums, List<List<Integer>> ans, boolean[] added, List<Integer> cur) {
4        
5        if(cur.size() == nums.length){
6            ans.add(new ArrayList<>(cur));
7            return;
8        }
9
10        for(int i = 0 ; i < nums.length ; i++){
11
12            if(added[i] || (i > 0 && nums[i] == nums[i-1] && added[i-1])){
13                continue;
14            }
15
16            added[i] = true;
17            cur.add(nums[i]);
18
19            permuteUnique(nums, ans, added, cur);
20
21            cur.remove(cur.size() - 1);
22            added[i] = false;
23        }
24            
25    }
26    
27    public List<List<Integer>> permuteUnique(int[] nums) {
28
29        int n = nums.length;
30        Arrays.sort(nums);
31        List<List<Integer>> ans = new ArrayList<>();
32        boolean[] added = new boolean[n];
33        permuteUnique(nums, ans, added, new ArrayList<>()); 
34
35        return ans;
36    }
37}