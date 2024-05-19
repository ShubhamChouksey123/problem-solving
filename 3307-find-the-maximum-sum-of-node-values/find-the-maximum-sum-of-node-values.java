class Solution {


    public long maximumValueSum(int[] nums, int k, int[][] edges) {

        int n = nums.length;
        Integer[] delta = new Integer[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + (long) nums[i];
            delta[i] = (nums[i] ^ k) - nums[i];
        }
        Arrays.sort(delta, Collections.reverseOrder());
        
        long positiveDelta = 0;
        for (int i = 0; i < n; i = i + 2) {
            if (i + 1 < n) {
                int thisDelta = delta[i] + delta[i + 1];
                if (thisDelta > 0) {
                    positiveDelta += thisDelta;
                }
            }
        }

        return sum + positiveDelta;

    }
}