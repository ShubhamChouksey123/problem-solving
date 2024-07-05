class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int n = nums.length, left = nums[0], right = Integer.MAX_VALUE ;
        if(n <= 2){
            return false;
        }

        for(int i = 1 ; i < n ; i++){
            if(nums[i] < left){
                left = nums[i];
            }
            else if(nums[i] > left && nums[i] < right){
                right = nums[i];
            }
            else if(nums[i] > right){
                return true;
            }
        }

        return false;
    }
}