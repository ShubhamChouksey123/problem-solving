class Solution {
    
    public int predictTheWinner(int[] nums, int[][] memoCache, int start, int end) {
        
        if(start == end) return nums[start];

        if(memoCache[start][end] != -1) return memoCache[start][end];

        int takeLeft = nums[start] -  predictTheWinner(nums, memoCache, start + 1, end);
        int takeRight = nums[end] -  predictTheWinner(nums, memoCache, start, end - 1);

        memoCache[start][end] = Math.max(takeLeft, takeRight);
        return memoCache[start][end];
    }
    
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] memoCache = new int[n][n];
        for(int[] row : memoCache) Arrays.fill(row, -1);

        return predictTheWinner(nums, memoCache, 0, n - 1) >= 0;    

    }
}