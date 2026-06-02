1class Solution {
2    
3    public int longestPalindromeSubseq(String s, int n, int[][] dp, int x, int y) {
4
5        if(x == n || y < 0)
6            return 0;
7
8        if(dp[x][y] != -1)
9            return dp[x][y];
10
11        if(s.charAt(x) == s.charAt(y)){
12            return 1 + longestPalindromeSubseq(s, n, dp, x + 1, y - 1); 
13        }
14
15        int a = longestPalindromeSubseq(s, n, dp, x + 1, y);
16        int b = longestPalindromeSubseq(s, n, dp, x, y - 1);
17
18        int optimalValue = Math.max(a, b);
19        dp[x][y] = optimalValue;
20        return optimalValue;
21    }
22    
23    public int longestPalindromeSubseq(String s) {
24
25        int n = s.length();   
26        int[][] dp = new int[n][n];
27        for(int[] row : dp){
28            Arrays.fill(row, -1);
29        }
30        return longestPalindromeSubseq(s, n, dp, 0, n - 1); 
31    }
32}