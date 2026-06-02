1class Solution {
2    public int calculateMinimumHP(int[][] dungeon) {
3        
4        int n = dungeon.length, m = dungeon[0].length;
5        int[][] dp = new int[n][m];
6
7        for(int i = n - 1 ; i >= 0 ; i--){
8            for(int j = m - 1 ; j >= 0 ; j--){
9                int minNextHealthRequired = Integer.MAX_VALUE;
10                if(i != n - 1){
11                    minNextHealthRequired = dp[i+1][j];
12                }
13                if(j != m - 1){
14                    minNextHealthRequired = dp[i][j+1];
15                }
16                if(minNextHealthRequired == Integer.MAX_VALUE){
17                    minNextHealthRequired = 0;
18                } 
19                
20                if(i != n - 1 && j != m - 1){
21                    minNextHealthRequired = Math.max(dp[i][j+1], dp[i+1][j]); 
22                }
23                
24                dp[i][j] = Math.min(dungeon[i][j] + minNextHealthRequired, 0);
25            }
26        }
27        return -1*dp[0][0] + 1;
28    }
29}