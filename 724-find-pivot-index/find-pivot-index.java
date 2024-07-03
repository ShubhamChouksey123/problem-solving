class Solution {
    public int pivotIndex(int[] nums) {

        int n = nums.length, rightSum = 0, leftSum = 0;
        
        for(int i = 0 ; i < n ; i++){
            rightSum += nums[i];
        }

        for(int i = 0 ; i < n ; i++){
            rightSum -= nums[i];

            if(leftSum == rightSum){
                return i;
            }   
            leftSum += nums[i];
        }

        return -1;
        
    }
}