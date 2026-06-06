1class Solution {
2    
3    private int maxSumAfterPartitioning(int[] arr, int k, int[] dp, int start) {
4        
5        if(start >= arr.length) return 0;
6        if(dp[start] != -1) return dp[start];
7
8        int maxValue = arr[start];
9        int maxSum = 0;
10        for(int end = start ; end <= Math.min(start + k - 1, arr.length - 1) ; end++){
11            maxValue = Math.max(maxValue, arr[end]);
12            int thisSetSum = maxValue * (end - start + 1);
13            int sum = thisSetSum + maxSumAfterPartitioning(arr, k, dp, end + 1); 
14            maxSum = Math.max(maxSum, sum);
15        }
16        dp[start] = maxSum;
17        return maxSum;
18    }
19    
20    public int maxSumAfterPartitioning(int[] arr, int k) {
21        int n = arr.length;
22        int[] dp = new int[n];
23        Arrays.fill(dp, -1);
24        return maxSumAfterPartitioning(arr, k, dp, 0);    
25    }
26}