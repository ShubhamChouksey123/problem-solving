class Solution {
    

    public int splitArray(int[] nums, int n, int[] prefixSum, int[][] memoCache, int start, int k) {

        if(k == 1) return prefixSum[n] - prefixSum[start];
        if(memoCache[start][k] != -1) return memoCache[start][k];

        int minMaxSum = Integer.MAX_VALUE;
        for(int end = start ; end <= n - k ; end++){
            int thisSum = prefixSum[end + 1] - prefixSum[start];
            int maxNextSum = splitArray(nums, n, prefixSum, memoCache, end + 1, k - 1);
            
            int maxSum = Math.max(thisSum, maxNextSum);
            minMaxSum = Math.min(minMaxSum, maxSum);
        } 
        memoCache[start][k] = minMaxSum;
        return minMaxSum;
    }
    
    public int splitArray(int[] nums, int k) {

        int n = nums.length;
        int[] prefixSum = new int[n+1];

        for(int i = 1 ; i <= n ; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        } 

        int[][] memoCache = new int[n][k + 1];
        for(int[] row : memoCache){
            Arrays.fill(row, -1);
        }

        return splitArray(nums, n, prefixSum, memoCache, 0, k) ;
    }
}