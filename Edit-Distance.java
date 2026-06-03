1class Solution {
2    public int minDistance(String word1, String word2) {
3
4        int n = word1.length(), m = word2.length();
5
6        int[][] dp = new int[n+1][m+1];
7
8        dp[0][0] = 0;
9        // first columnn
10        for(int i = 1 ; i <= n ; i++){
11            dp[i][0] = i;
12        }
13
14        // first row
15        for(int j = 1 ; j <= m ; j++){
16            dp[0][j] = j;
17        }
18
19        for(int i = 1 ; i <= n ; i++){
20            for(int j = 1 ; j <= m ; j++){
21                if(word1.charAt(i-1) == word2.charAt(j-1)){
22                    dp[i][j] = dp[i-1][j-1];
23                }
24                else{
25                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
26                }
27            }
28        }
29        return dp[n][m];
30    }
31}