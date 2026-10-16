class Solution {
    

    public int splitArray(int[] nums, int n, int[] predixSum, int[][] memoCache, int start, int k) {

        if(k == 1) return predixSum[n] - predixSum[start];
        if(memoCache[start][k] != -1) return memoCache[start][k];

        int minMaxSum = Integer.MAX_VALUE;
        for(int end = start ; end <= n - k ; end++){
            int thisSum = predixSum[end + 1] - predixSum[start];
            int maxNextSum = splitArray(nums, n, predixSum, memoCache, end + 1, k - 1);;
            
            int maxSum = Math.max(thisSum, maxNextSum);
            minMaxSum = Math.min(minMaxSum, maxSum);
        } 
        memoCache[start][k] = minMaxSum;
        return minMaxSum;
    }
    
    public int splitArray(int[] nums, int k) {

        int n = nums.length;
        int[] predixSum = new int[n+1];

        for(int i = 1 ; i <= n ; i++){
            predixSum[i] = predixSum[i-1] + nums[i-1];
        } 

        int[][] memoCache = new int[n][k + 1];
        for(int[] row : memoCache){
            Arrays.fill(row, -1);
        }

        return splitArray(nums, n, predixSum, memoCache, 0, k) ;
    }
}