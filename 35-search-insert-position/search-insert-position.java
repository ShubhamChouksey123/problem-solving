class Solution {
    public int searchInsert(int[] nums, int target, int start, int end) {

        if (start == end && nums[start] == target)
            return start;

        if (start == end) {
            if (nums[start] < target) {
                return start + 1;
            }else{
                return start;
            }
        }


        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (target > nums[mid]) {
            return searchInsert(nums, target, mid + 1, end);
        }
        return searchInsert(nums, target, start, mid);
    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        return searchInsert(nums, target, 0, n - 1);
    }
}