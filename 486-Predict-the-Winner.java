class Solution {
    private int predictTheWinner(int[] nums, int[][] memoCache, int start, int end) {
        
        if(start == end) return nums[start];
        if(start > end) return 0;
        if(memoCache[start][end] != -1) return memoCache[start][end];

        int a = nums[start] - predictTheWinner(nums, memoCache, start + 1, end); 
        int b = nums[end] - predictTheWinner(nums, memoCache, start, end - 1); 
                
        int optimalValue = Math.max(a, b);
        memoCache[start][end] = optimalValue;
        return optimalValue;
    }
    
    public boolean predictTheWinner(int[] nums) {
        
        int n = nums.length;
        int[][] memoCache = new int[n][n];
        for(int[] row : memoCache){
            Arrays.fill(row, -1);
        }
        int ans = predictTheWinner(nums, memoCache, 0, n - 1) ;

        return ans >= 0;
    }
}