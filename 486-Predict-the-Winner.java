class Solution {
    public int predictTheWinner(int[] nums, int start, int end) {
        
        if(start == end) return nums[start];
        if(start > end) return 0;

        int a = nums[start] - predictTheWinner(nums, start + 1, end); 
        int b = nums[end] - predictTheWinner(nums, start, end - 1); 
                

        int optimalValue = Math.max(a, b);
        return optimalValue;
    }
    
    public boolean predictTheWinner(int[] nums) {
        
        int n = nums.length;
        int ans = predictTheWinner(nums, 0, n - 1) ;

        return ans >= 0;
    }
}