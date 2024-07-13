class Solution {

    /**
    x and y are length of string 1 and string 2 
     */
    public int minDistance(String word1, String word2, int m, int n, int x, int y, int[][] dp) {
        if(x == 0 && y == 0){
            return 0;
        }
        if(x == 0 && y > 0){
            return y;
        }
        if(y == 0 && x > 0){
            return x;
        }

        if(dp[x][y] != -1){
            return dp[x][y];
        }
    
        int ans = Integer.MAX_VALUE;
        int a = minDistance(word1, word2, m, n, x-1, y-1, dp);
        if(word1.charAt(x-1) == word2.charAt(y-1)){
            dp[x][y] = a;
            return a;
        }
        int b =  minDistance(word1, word2, m, n, x-1, y, dp);
        int c =  minDistance(word1, word2, m, n, x, y-1, dp);

        dp[x][y] = 1 + Math.min(a, Math.min(b, c));
        return dp[x][y];
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] inner : dp){
            Arrays.fill(inner, -1);
        }

        return minDistance(word1, word2, m, n, m, n, dp);     
    }
}