class Solution {
    
    
    public int minPathSum(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];


        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE; 
                if(i >= 1){
                    a = dp[i-1][j] + grid[i][j];
                }
                if(j >= 1){
                    b = dp[i][j-1] + grid[i][j];  
                }
                dp[i][j] = Math.min(a, b);
            }
        }
        return dp[m-1][n-1];
    }
}