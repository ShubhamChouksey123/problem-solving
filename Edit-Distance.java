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
12        if(dp[x][y] != -1)
13            return dp[x][y];
14        
15        if(word1.charAt(x - 1) == word2.charAt(y - 1)){
16            dp[x][y] = minDistance(word1, word2, n , m, dp, x - 1, y - 1);
17            return dp[x][y];
18        }
19
20        int a = minDistance(word1, word2, n , m, dp, x - 1, y);
21        int b = minDistance(word1, word2, n , m, dp, x, y - 1);
22        int c = minDistance(word1, word2, n , m, dp, x - 1, y - 1);
23
24        int optimalValue = Math.min(a, Math.min(b, c)) + 1;
25        dp[x][y] = optimalValue;
26        return optimalValue;
27    }
28
29    public int minDistance(String word1, String word2) {
30        
31        int n = word1.length(), m = word2.length();
32        int[][] dp = new int[n+1][m+1];
33        for(int[] row : dp){
34            Arrays.fill(row, -1);
35        }
36        
37        return  minDistance(word1, word2, n , m, dp, n, m);
38    }
39}