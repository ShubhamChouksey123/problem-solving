class Solution {
    

    public int getMaximumGold(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int maxScore = 0;
        boolean[][] visited = new boolean[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    int currentScore = getGold(grid, m, n, i, j, visited);
                    maxScore = Math.max(currentScore, maxScore);
                }
            }
        }

        return maxScore;
    }

    private boolean liesInRange(int m, int n, int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return true;
        }
        return false;
    }

    /**
     * x => i
     * y =? j
     */
    public int getGold(int[][] grid, int m, int n, int x, int y, boolean[][] visited) {

        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) {
            return 0;
        }

        visited[x][y] = true;

        int score1 = 0, score2 = 0, score3 = 0, score4 = 0;

        score1 = getGold(grid, m, n, x + 1, y, visited);
        score3 = getGold(grid, m, n, x - 1, y, visited);
        score2 = getGold(grid, m, n, x, y + 1, visited);
        score4 = getGold(grid, m, n, x, y - 1, visited);


        visited[x][y] = false;
        return Math.max(Math.max(score1, score2), Math.max(score3, score4)) + grid[x][y];
    }
}