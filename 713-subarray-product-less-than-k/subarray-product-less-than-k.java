class Solution {


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long prod = 1;

        int start = 0, n = nums.length, count = 0;

        for(int end = 0 ; end < n ; end++){
            prod *= nums[end];
            
            while(start <= end && prod >= k){
                prod /= nums[start]; 
                start++;
            }

            if(end - start >= 0){
                count += (end - start + 1); 
                System.out.println("count : " + count);
            }
            
        }

        return count;
    }
}