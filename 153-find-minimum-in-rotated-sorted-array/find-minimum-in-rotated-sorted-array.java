class Solution {
    private int findMin(int[] nums, int n, int start, int end) {

        if (start == end) {
            return nums[start];
        }

        if (start + 1 == end) {
            return Math.min(nums[start], nums[end]);
        }
        int mid = (start + end) / 2;

        if (nums[mid - 1] > nums[mid] && nums[mid + 1] > nums[mid]) {
            return nums[mid];
        }

        if (nums[start] < nums[mid]) {
            /**
             * first half is monotonic increasing
             */
            if (nums[start] > nums[end]) {
                return findMin(nums, n, mid + 1, end);
            } else {
                return findMin(nums, n, start, mid);
            }
        }
        if (nums[mid] < nums[end]) {
            /**
             * second half is monotonic increasing
             */
            if (nums[start] > nums[end]) {
                return findMin(nums, n, start, mid);
            } else {
                return findMin(nums, n, mid + 1, end);
            }
        }
        System.out.println("edge case with " + start + " and end : " + end);
        return -1;
    }

    public int findMin(int[] nums) {
        int n = nums.length;
        return findMin(nums, n, 0, n - 1);
    }
}