class Solution {
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public int removeElement(int[] nums, int val) {

        int n = nums.length;
        int start = 0;
        int current = 0;

        for (current = 0; current < n; current++) {
            if (nums[current] != val) {
                swap(nums, start, current);
                start++;
            }
        }

        return start;
    }
}