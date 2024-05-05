class Solution {
    
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int curMax = nums[0];
        int curMin = nums[0];
        int maxSubArraySum = nums[0];
        int minSubArraySum = nums[0];
        int totalSum = nums[0];
        for (int end = 1; end < n; end++) {
            if (curMax > 0) {
                curMax = curMax + nums[end];
            } else {
                curMax = nums[end];
            }

            if (curMin < 0) {
                curMin = curMin + nums[end];
            } else {
                curMin = nums[end];
            }

            totalSum += nums[end];
            maxSubArraySum = Math.max(maxSubArraySum, curMax);
            minSubArraySum = Math.min(minSubArraySum, curMin);
        }

        if (maxSubArraySum < 0) {
            return maxSubArraySum;
        }


        return Math.max(maxSubArraySum, totalSum - minSubArraySum);

    }

}