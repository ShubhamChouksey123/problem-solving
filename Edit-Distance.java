1class Solution {
2
3    private int minDistance(String word1, String word2, int n , int m, int[][] dp, int x, int y){
4
5        if(x == 0 && y > 0)
6            return y;
7        if(x > 0 && y == 0)
8            return x;
9        if(x == 0 && y == 0)
10            return 0;
11
12        if(dp[x-1][y-1] != -1)
13            return dp[x-1][y-1];
14        
15        if(word1.charAt(x - 1) == word2.charAt(y - 1)){
16            return minDistance(word1, word2, n , m, dp, x - 1, y - 1);
17        }
18
19        int a = minDistance(word1, word2, n , m, dp, x - 1, y);
20        int b = minDistance(word1, word2, n , m, dp, x, y - 1);
21        int c = minDistance(word1, word2, n , m, dp, x - 1, y - 1);
22
23        int optimalValue = Math.min(a, Math.min(b, c)) + 1;
24        dp[x-1][y-1] = optimalValue;
25        return optimalValue;
26    }
27
28    public int minDistance(String word1, String word2) {
29        
30        int n = word1.length(), m = word2.length();
31        int[][] dp = new int[n][m];
32        for(int[] row : dp){
33            Arrays.fill(row, -1);
34        }
35        
36        return  minDistance(word1, word2, n , m, dp, n, m);
37    }
38}