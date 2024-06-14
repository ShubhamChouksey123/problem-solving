class Solution {
     public int minIncrementForUnique(int[] nums) {

        int n = nums.length;

        Arrays.sort(nums);

        int next = nums[0];
        int increment = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < next) {
                increment += (next - nums[i]);
            }
            next = Math.max(next + 1, nums[i] + 1);
        }
        return increment;
    }
}