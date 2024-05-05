class Solution {
     public int findPeakElementUtil(int[] nums, int n, int start, int end) {

        if (start == end) {
            return start;
        }

        int mid = (start + end) / 2;

        if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
            return mid;
        } else if (nums[mid - 1] > nums[mid]) {
            return findPeakElementUtil(nums, n, start, mid);
        }
        return findPeakElementUtil(nums, n, mid + 1, end);

    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        return findPeakElementUtil(nums, n, 0, n - 1);
    }
}