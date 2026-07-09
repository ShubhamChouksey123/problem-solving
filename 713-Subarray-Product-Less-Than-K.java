class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int n = nums.length;
        int start = 0, end = 0;
        int count = 0, prod = 1;
        for(end = 0 ; end < n ; end++){
            prod = prod * nums[end];
            while(prod >= k && start <= end){
                prod = prod / nums[start];
                start++;
            }
            if(end >= start && prod < k)
                count += (end - start + 1);
        }  
        return count;
        
    }
}