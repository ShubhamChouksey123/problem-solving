class Solution {
    public int findMaxK(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return -1;
        }


        Integer ans = -1;
        Map<Integer, Boolean> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Boolean isPresent = mp.get(-1 * nums[i]);
            if (Objects.equals(isPresent, Boolean.TRUE)) {
                ans = Math.max(ans, Math.abs(nums[i]));
            }
            mp.put(nums[i], true);
        }

        return ans;
    }
}