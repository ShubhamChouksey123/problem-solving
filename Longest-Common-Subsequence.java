1class Solution {
2    
3    private int longestCommonSubsequence(String text1, String text2, int n, int m, int[][] dp, int x, int y) {
4        
5        if(x < 0 || y < 0)
6            return 0;
7        
8        if(dp[x][y] != -1)
9            return dp[x][y];
10
11        if(text1.charAt(x) == text2.charAt(y)){
12            return 1 + longestCommonSubsequence(text1, text2, n, m, dp, x - 1, y - 1);
13        }
14
15        int a = longestCommonSubsequence(text1, text2, n, m, dp, x - 1, y); 
16        int b = longestCommonSubsequence(text1, text2, n, m, dp, x, y - 1);
17
18        int optimalValue = Math.max(a, b);
19        dp[x][y] = optimalValue;
20        return optimalValue; 
21
22    }
23    
24    public int longestCommonSubsequence(String text1, String text2) {
25
26        int n = text1.length(), m = text2.length();
27        int[][] dp = new int[n][m];
28        for(int[] row : dp){
29            Arrays.fill(row, -1);
30        }
31        
32        return longestCommonSubsequence(text1, text2, n, m, dp, n - 1, m - 1);  
33    }
34}
35
36/**
37
38"abcdeefgqznxkddxxws"
39"acebcesnsdwandjadna"
40
41"abcdeefgqznxkddxxwsandsdnbagfsvafdtxvsa"
42"acebcesnsdwandjadnasvafscvxbagsvdya"
43 */