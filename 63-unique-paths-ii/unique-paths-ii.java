class Solution {

    private boolean liesInRange(int m, int n, int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n)
            return true;
        return false;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] uniquePaths = new int[m][n];
        uniquePaths[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                int totalPath = 0;
                if (liesInRange(m, n, i - 1, j) && obstacleGrid[i - 1][j] == 0) {
                    totalPath += uniquePaths[i - 1][j];
                }
                if (liesInRange(m, n, i, j - 1) && obstacleGrid[i][j - 1] == 0) {
                    totalPath += uniquePaths[i][j - 1];
                }
                uniquePaths[i][j] = totalPath;
            }
        }
        return uniquePaths[m - 1][n - 1];

    }
}