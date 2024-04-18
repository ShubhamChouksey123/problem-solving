class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
    
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;


        for (end = 0; end < n; end++) {

            currentSum += nums[end];

            while (currentSum >= target && start <= end) {
                minLength = Math.min(minLength, end - start + 1);
                currentSum = currentSum - nums[start];
                start++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }

        return minLength;
    }
}