class Solution {

    public int rob(int[] nums, int[] memoCache, int start, int end) {
        if(start > end) return 0;
        if(memoCache[start] != -1) return memoCache[start];
        
        int take = nums[start] + rob(nums, memoCache, start + 2, end);
        int notTake = rob(nums, memoCache, start + 1, end);

        int optimalValue = Math.max(take, notTake);
        memoCache[start] = optimalValue;
        return optimalValue;
    }

    public int rob(int[] nums) {
        
        int n = nums.length;
        int[] memoCache = new int[nums.length];
        if(n == 1) return nums[0];
        
        Arrays.fill(memoCache, -1);
        int a = rob(nums, memoCache, 0, n - 2);  

        Arrays.fill(memoCache, -1);
        int b = rob(nums, memoCache, 1, n - 1); 

        return Math.max(a, b); 
    }
}