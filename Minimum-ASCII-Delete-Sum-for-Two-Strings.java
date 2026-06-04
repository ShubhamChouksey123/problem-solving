1class Solution {
2    public int minimumDeleteSum(String s1, String s2) {
3
4        int n = s1.length(), m = s2.length();
5        int[][] dp = new int[n+1][m+1];
6        dp[0][0] = 0;
7
8        // first column
9        for(int i = 1 ; i <= n ; i++){
10            dp[i][0] = (int)s1.charAt(i-1) + dp[i-1][0];
11        }
12
13        // first row
14        for(int j = 1 ; j <= m ; j++){
15            dp[0][j] = (int)s2.charAt(j-1) + dp[0][j-1];
16        }
17
18        for(int i = 1 ; i <= n ; i++){
19            for(int j = 1 ; j <= m ; j++){
20                if(s1.charAt(i-1) == s2.charAt(j-1)){
21                    dp[i][j] = dp[i-1][j-1];
22                }
23                else{
24                    dp[i][j] = Math.min(
25                        dp[i-1][j] + (int)s1.charAt(i-1),
26                        dp[i][j-1] + (int)s2.charAt(j-1)
27                    );
28                }
29            }
30        }
31
32        return dp[n][m];
33    }
34}