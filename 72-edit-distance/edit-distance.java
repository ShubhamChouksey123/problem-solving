class Solution {
    

      public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        if (m == 0 || n == 0)
            return Math.max(m, n);

        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;

        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char char1 = word1.charAt(i - 1);
                char char2 = word2.charAt(j - 1);

                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                int minValue = Math.min(dp[i - 1][j], dp[i][j - 1]);
                minValue = Math.min(minValue, dp[i - 1][j - 1]);

                dp[i][j] = minValue + 1;

            }
        }
        return dp[m][n];
    }
    
}