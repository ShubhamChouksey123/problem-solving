class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        if (nums[n - 1] < 0) {
            return 0;
        }
        if (nums[0] >= n) {
            return n;
        }

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == n - i) {
                    return nums[i];
                }
                int numberOfElementsOnRight = n - i;
                if (numberOfElementsOnRight < nums[i] && nums[i - 1] < numberOfElementsOnRight) {
                    return numberOfElementsOnRight;
                }
            }
        }

        return -1;
    }
}