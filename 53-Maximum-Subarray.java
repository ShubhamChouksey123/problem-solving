class Solution {
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int start = 0;
        int subArraySum = 0;
        int maxSubArraySum = Integer.MIN_VALUE;

        for(int end = 0 ; end < n ; end++){
            subArraySum += nums[end];
            maxSubArraySum = Math.max(maxSubArraySum, subArraySum);

            while(subArraySum < 0){
                subArraySum -= nums[start];
                start++;
            }
        }
        return maxSubArraySum;
    }
}