class Solution {
    private void numIslandsUtil(char[][] grid, int m, int n, boolean[][] visited, int x, int y) {

        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == '0') {
            return;
        }

        visited[x][y] = true;

        numIslandsUtil(grid, m, n, visited, x + 1, y);
        numIslandsUtil(grid, m, n, visited, x - 1, y);
        numIslandsUtil(grid, m, n, visited, x, y + 1);
        numIslandsUtil(grid, m, n, visited, x, y - 1);
    }

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int totalIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    numIslandsUtil(grid, m, n, visited, i, j);
                    totalIsland++;
                }
            }
        }
        return totalIsland;
    }
}