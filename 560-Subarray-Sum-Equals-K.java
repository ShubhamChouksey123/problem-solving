class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        int sum = 0;
        int subArrayWithKSum = 0;
        for(int end = 0 ; end < n ; end++){
            sum += nums[end];
            int prefixCount = prefixSumCount.getOrDefault(sum - k, 0);
            subArrayWithKSum += prefixCount;

            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        return subArrayWithKSum;
    }
}