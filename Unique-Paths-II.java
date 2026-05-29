1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3
4        int n = obstacleGrid.length, m = obstacleGrid[0].length;
5
6        if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1)
7            return 0;
8
9        int[][] dp = new int[n][m];
10        for(int[] row : dp){
11            Arrays.fill(row, 0);
12        }
13        dp[0][0] = 1;
14
15        for(int i = 0 ; i < n ; i++){
16            for(int j = 0 ; j < m ; j++){
17                if(obstacleGrid[i][j] == 1)
18                    continue;
19                if(i-1 >= 0){
20                    dp[i][j] = dp[i-1][j]; 
21                }
22                if(j-1 >= 0){
23                    dp[i][j] += dp[i][j-1]; 
24                }
25            }
26        }
27        return dp[n-1][m-1];
28    }
29}