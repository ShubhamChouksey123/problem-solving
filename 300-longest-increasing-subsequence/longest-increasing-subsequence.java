class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        /**
         * where longestSubSequence[i] represent longest subsequence start from index i
         */
        int[] longestSubSequence = new int[n];
        longestSubSequence[n - 1] = 1;
        int ans = 1;

        for (int i = n - 2; i >= 0; i--) {
            longestSubSequence[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    longestSubSequence[i] = Math.max(longestSubSequence[j] + 1, longestSubSequence[i]);
                }
            }
            ans = Math.max(ans, longestSubSequence[i]);
        }
        // System.out.println("longestSubSequence : " + Arrays.toString(longestSubSequence));
        return ans;
    }
}