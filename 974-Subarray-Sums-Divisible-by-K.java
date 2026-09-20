class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int n = nums.length;
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);

        int sum = 0;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            int rem = ((sum % k )+ k) % k;
            count += remainderCount.getOrDefault(rem, 0);
            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }
        return count;

    }
}