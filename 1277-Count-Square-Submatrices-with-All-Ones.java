class Solution {
    public int countSquares(int[][] matrix) {
        
        int n = matrix.length, m = matrix[0].length, count = 0;
        int[][] dp = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == 0) continue;
                int a = 0, b = 0, c = 0;
                if(i - 1 >= 0) a = dp[i-1][j];
                if(j - 1 >= 0) b = dp[i][j-1];
                if(i - 1 >= 0&& j - 1 >= 0) c = dp[i-1][j-1];

                dp[i][j] = 1 + Math.min(c, Math.min(a, b));
                count += dp[i][j];
            }
        }
        return count;

    }
}