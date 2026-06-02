1class Solution {
2    public int longestCommonSubsequence(String text1, String text2) {
3
4        int n = text1.length(), m = text2.length();
5        int[][] dp = new int[n+1][m+1];
6        for(int[] row : dp){
7            Arrays.fill(row, 0);
8        }
9
10        for(int i = 1 ; i <= n ; i++){
11            for(int j = 1 ; j <= m ; j++){
12                if(text1.charAt(i-1) == text2.charAt(j-1)){
13                    dp[i][j] = 1 + dp[i-1][j-1];
14                }
15                else{
16                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
17                }
18            }
19        }
20        return dp[n][m];
21    }
22}