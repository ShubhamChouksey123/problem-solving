1class Solution {
2
3    public int uniquePathsUtil(int[][] dp, int x, int y) {
4
5        if(x == 0 || y == 0)
6            return 1;
7
8        if(dp[x][y] != -1){
9            return dp[x][y];
10        }
11        
12        dp[x][y] = uniquePathsUtil(dp, x - 1, y) + uniquePathsUtil(dp, x, y - 1);   
13        return dp[x][y];
14    }
15
16    public int uniquePaths(int n, int m) {
17
18        int[][] dp = new int[n][m];
19        for(int[] row : dp){
20            Arrays.fill(row, -1);
21        }
22        
23        return uniquePathsUtil(dp, n - 1, m - 1);
24        
25    }
26}