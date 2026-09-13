class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int n = nums.length;
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);

        // sum starting from start of array
        int sum = 0;
        int countSubArrayDivByK = 0;
        for(int end = 0 ; end < n ; end++){
            sum += nums[end];
            int remainder = ((sum % k) + k) % k;

            countSubArrayDivByK += remainderCount.getOrDefault(remainder, 0);
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return countSubArrayDivByK;
    }
}