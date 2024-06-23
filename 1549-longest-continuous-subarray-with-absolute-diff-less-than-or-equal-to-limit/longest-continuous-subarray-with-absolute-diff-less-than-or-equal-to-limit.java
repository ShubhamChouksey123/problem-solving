class Solution {
     public int longestSubarray(int[] nums, int limit) {
        int n = nums.length, curLimit = 0, maxLength = 0, start = 0;

        /**
         * Map of 
         * num -> count
         */
        TreeMap<Integer, Integer> counts = new TreeMap<>();

        for (int end = 0; end < n; end++) {

            counts.merge(nums[end], 1, Integer::sum);

            curLimit = counts.lastKey() - counts.firstKey();

            while (curLimit > limit) {
                int currentCount = counts.get(nums[start]);
                if (currentCount == 1) {
                    counts.remove(nums[start]);
                } else {
                    counts.put(nums[start], currentCount - 1);
                }
                start++;
                curLimit = counts.lastKey() - counts.firstKey();
            }

            // System.out.println("start : " + start + ", end : " + end + " and curLimit : " + curLimit);
            maxLength = Math.max(maxLength, end - start + 1);

        }
        return maxLength;
    }
}