1class Solution {
2    public int calculateMinimumHP(int[][] dungeon) {
3
4        int n = dungeon.length, m = dungeon[0].length;
5        int[][] dp = new int[n][m];
6
7        for(int i = n - 1 ; i >= 0 ; i--){
8            for(int j = m - 1 ; j >= 0 ; j--){
9                int best = 0;
10                if(i + 1 < n && j + 1 < m){
11                    best = Math.min(dp[i+1][j], dp[i][j+1]);
12                }
13                else if(i + 1 < n){
14                    best = dp[i+1][j];
15                }
16                else if(j + 1 < m){
17                    best = dp[i][j+1];
18                }
19                               
20                dp[i][j] = Math.max(0, - dungeon[i][j] + best);
21            }
22        }
23
24        
25        return dp[0][0] + 1;
26    }
27}