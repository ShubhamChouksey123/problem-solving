class Solution {
    
    public int predictTheWinner(int[] nums, int start, int end) {
        
        if(start == end) return nums[start];

        int takeLeft = nums[start] -  predictTheWinner(nums, start + 1, end);
        int takeRight = nums[end] -  predictTheWinner(nums, start, end - 1);

        return Math.max(takeLeft, takeRight);
    }
    
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        return predictTheWinner(nums, 0, n - 1) >= 0;    

    }
}