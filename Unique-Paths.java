1class Solution {
2    /**
3    
4        n rows and m columns 
5     */
6    public int uniquePaths(int n, int m) {
7
8        int[][] dp = new int[n][m];
9        
10        // first column
11        for(int i = 0 ; i < n ; i++){
12            dp[i][0] = 1;
13        }
14
15        // first row
16        for(int j = 0 ; j < m ; j++){
17            dp[0][j] = 1;
18        }
19
20        for(int i = 1; i < n ; i++){
21            for(int j = 1; j < m ; j++){
22                dp[i][j] = dp[i-1][j] + dp[i][j-1];
23            }
24        }
25
26        return dp[n-1][m-1];
27    }
28}