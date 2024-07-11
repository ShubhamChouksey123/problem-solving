class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];

        int prod = nums[0];
        ans[0] = 1;
        for(int i = 1; i < n ; i++){
            ans[i] = prod;
            prod *= nums[i];
        }

        prod = nums[n-1];
        for(int i = n-2; i >= 0 ; i--){
            ans[i] *= prod;
            prod *= nums[i];
        }

        return ans;
    }
}