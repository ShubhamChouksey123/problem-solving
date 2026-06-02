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
12            int ans = 1 + longestPalindromeSubseq(s, n, dp, x + 1, y - 1); 
13            dp[x][y] = ans;
14            return ans;
15        }
16
17        int a = longestPalindromeSubseq(s, n, dp, x + 1, y);
18        int b = longestPalindromeSubseq(s, n, dp, x, y - 1);
19
20        int optimalValue = Math.max(a, b);
21        dp[x][y] = optimalValue;
22        return optimalValue;
23    }
24    
25    public int longestPalindromeSubseq(String s) {
26
27        int n = s.length();   
28        int[][] dp = new int[n][n];
29        for(int[] row : dp){
30            Arrays.fill(row, -1);
31        }
32        return longestPalindromeSubseq(s, n, dp, 0, n - 1); 
33    }
34}