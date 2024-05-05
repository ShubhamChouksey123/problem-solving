class Solution {
    

    public int findFirstIndex(int[] nums, int target, int start, int end) {

        if (start == end) {
            if (nums[start] == target) {
                return start;
            }
            return -1;
        }

        int mid = (start + end) / 2;

        if (target <= nums[mid]) {
            return findFirstIndex(nums, target, start, mid);
        } else if (target > nums[mid]) {
            return findFirstIndex(nums, target, mid + 1, end);
        }

        return 0;
    }

    public int findLastIndex(int[] nums, int target, int start, int end) {

        if (start == end) {
            if (nums[start] == target) {
                return start;
            }
            return -1;
        }
        if (start + 1 == end) {
            if (nums[end] == target) {
                return end;
            }
            if (nums[start] == target) {
                return start;
            }
            return -1;
        }


        int mid = (start + end) / 2;

        if (target < nums[mid]) {
            return findLastIndex(nums, target, start, mid - 1);
        } else if (target >= nums[mid]) {
            return findLastIndex(nums, target, mid, end);
        }

        return 0;
    }

    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        if (n < 1) {
            return ans;
        }


        ans[0] = findFirstIndex(nums, target, 0, n - 1);
        ans[1] = findLastIndex(nums, target, 0, n - 1);

        return ans;
    }
}