class Solution {
    
    private void permuteUnique(int[] nums, List<List<Integer>> ans, boolean[] added, List<Integer> cur) {
        
        if(cur.size() == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){

            if(added[i] || (i > 0 && nums[i] == nums[i-1] && added[i-1])){
                continue;
            }

            added[i] = true;
            cur.add(nums[i]);

            permuteUnique(nums, ans, added, cur);

            cur.remove(cur.size() - 1);
            added[i] = false;
        }
            
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] added = new boolean[n];
        permuteUnique(nums, ans, added, new ArrayList<>()); 

        return ans;
    }
}