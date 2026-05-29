1class Solution {
2    public int minPathSum(int[][] grid) {
3
4        int n = grid.length, m = grid[0].length;
5        int[][] dp = new int[n][m];
6        for(int[] row : dp){
7            Arrays.fill(row, Integer.MAX_VALUE);
8        }
9        dp[0][0] = grid[0][0]; 
10
11        for(int i = 0 ; i < n ; i++){
12            for(int j = 0; j < m ; j++){
13                if(i-1 >= 0){
14                    dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[i-1][j]);
15                }
16                if(j-1 >= 0){
17                    dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[i][j-1]);
18                }
19            }
20        }
21
22        return dp[n-1][m-1];
23    }
24}