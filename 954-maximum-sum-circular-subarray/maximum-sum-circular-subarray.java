class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        if(n <= 1){
            return nums[0];
        }
        int maxSum = nums[0];
        int minSum = nums[0];
        int currentMaxSum = nums[0];
        int currentMinSum = nums[0];
        int total = nums[0];
        for(int i = 1 ; i < n ; i++){
            int number = nums[i];
            currentMaxSum = Math.max(currentMaxSum + number, number);
            currentMinSum = Math.min(currentMinSum + number , number);

            maxSum = Math.max(currentMaxSum, maxSum);
            minSum = Math.min(currentMinSum, minSum);
            total += number;
        }

        if(total - minSum> 0){
            return Math.max(maxSum, total - minSum);   
        }
        return maxSum;
    }
}