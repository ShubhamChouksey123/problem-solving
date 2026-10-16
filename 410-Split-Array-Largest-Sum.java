class Solution {
    

    public int splitArray(int[] nums, int n, int[][] sum, int[][] memoCache, int start, int k) {

        if(k <= 0) return -1;
        if(k == 1) return sum[start][n - 1];
        if(memoCache[start][k] != -1) return memoCache[start][k];

        int minMaxSum = Integer.MAX_VALUE;
        for(int end = start ; end < n ; end++){
            int thisSum = sum[start][end];
            int maxNextSum = 0;
            if(end + 1 < n && k > 0){
                maxNextSum = splitArray(nums, n, sum, memoCache, end + 1, k - 1);
            }
            int maxSum = Math.max(thisSum, maxNextSum);
            minMaxSum = Math.min(minMaxSum, maxSum);
        } 
        memoCache[start][k] = minMaxSum;
        return minMaxSum;
    }
    
    public int splitArray(int[] nums, int k) {

        int n = nums.length;
        int[][] sum = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            int currentSum = 0;
            for(int j = i ; j < n ; j++){
                currentSum += nums[j];
                sum[i][j] = currentSum;
            }
        } 

        int[][] memoCache = new int[n][k + 1];
        for(int[] row : memoCache){
            Arrays.fill(row, -1);
        }

        return splitArray(nums, n, sum, memoCache, 0, k) ;
    }
}