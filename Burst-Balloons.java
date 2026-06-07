1class Solution {
2
3    public int maxCoins(int[] nums, int[][] dp, int start, int end) {
4
5        if(start > end)
6            return 0;
7        if(dp[start][end] != -1)
8            return dp[start][end];
9
10        int maxCoinsCollected = 0;
11        for(int index = start ; index <= end ; index++){
12            int currentBalloon = nums[start - 1] * nums[index] * nums[end + 1]; 
13            int subProblemleft = maxCoins(nums, dp, start, index - 1);
14            int subProblemRight = maxCoins(nums, dp, index + 1, end);
15            int cointCollected = currentBalloon + subProblemleft + subProblemRight;
16            maxCoinsCollected = Math.max(maxCoinsCollected, cointCollected);
17        }
18        dp[start][end] = maxCoinsCollected;
19        return maxCoinsCollected;
20    }
21
22    public int maxCoins(int[] nums) {
23
24        int n = nums.length;
25        int[] newNums = new int[n+2];
26        newNums[0] = 1; newNums[n+1] = 1;
27        for(int i = 1 ; i <= n ; i++){
28            newNums[i] = nums[i-1];
29        }
30        
31        int[][] dp = new int[n+2][n+2];
32        for(int[] row : dp){
33            Arrays.fill(row, -1);
34        }
35
36        return maxCoins(newNums, dp, 1, n); 
37    }
38}