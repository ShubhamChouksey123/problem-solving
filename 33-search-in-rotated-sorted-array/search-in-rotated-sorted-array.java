class Solution {
    private int searchUtil(int[] nums, int target, int start, int end) {

        if (start == end) {
            if (nums[start] == target) {
                return start;
            }
            return -1;
        }

        int mid = (start + end) / 2;

        if (target == nums[mid]) {
            return mid;
        }

        if (nums[start] < nums[mid]) {
            /**
             * first half is purely increasing
             */
            if (target >= nums[start] && target < nums[mid]) {
                return searchUtil(nums, target, start, mid);
            } else {
                return searchUtil(nums, target, mid + 1, end);
            }
        } else if (nums[mid] < nums[end]) {
            /**
             * second half is purely increasing
             */
            if (target > nums[mid] && target <= nums[end]) {
                return searchUtil(nums, target, mid + 1, end);
            } else {
                return searchUtil(nums, target, start, mid);
            }
        }

        if (start == mid) {
            return searchUtil(nums, target, mid + 1, end);
        }
        return -1;

    }

    public int search(int[] nums, int target) {
        return searchUtil(nums, target, 0, nums.length - 1);
    }
}