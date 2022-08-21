class Solution {
    
    
    public List<Integer> findLonely(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        
        if( n == 1 || (n > 1 && nums[0] != nums[1] && nums[0] + 1 != nums[1]) ){
            ans.add(nums[0]);
        }
        
        for(int i = 1 ; i < n -1 ; i++){
            if(nums[i] == nums[i-1] || nums[i] == nums[i-1]  + 1 ){
                continue;
            }
            if(nums[i] == nums[i+1]  || nums[i] + 1 == nums[i+1] ) {
                continue;
            }
            ans.add(nums[i]);
        }
        
        if( n > 1 && nums[n-1] != nums[n-2] &&  nums[n-1] != nums[n-2]  + 1){
            ans.add(nums[n-1]);
        }
        
        
        return ans;
        
    }
}