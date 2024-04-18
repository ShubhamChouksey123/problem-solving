class Solution {

    public int findEachCellParameter(int[][] grid, int m, int n, int x, int y) {

        int parameter = 0;
        if (!liesInRange(m, n, x + 1, y)) {
            parameter++;
        } else {
            if (grid[x + 1][y] == 0) {
                parameter++;
            }
        }

        if (!liesInRange(m, n, x, y + 1)) {
            parameter++;
        } else {
            if (grid[x][y + 1] == 0) {
                parameter++;
            }
        }

        if (!liesInRange(m, n, x - 1, y)) {
            parameter++;
        } else {
            if (grid[x - 1][y] == 0) {
                parameter++;
            }
        }

        if (!liesInRange(m, n, x, y - 1)) {
            parameter++;
        } else {
            if (grid[x][y - 1] == 0) {
                parameter++;
            }
        }
        return parameter;
    }

    public boolean liesInRange(int m, int n, int x, int y) {
        if (x >= 0 && y >= 0 && x < m && y < n)
            return true;
        return false;
    }
    public int islandPerimeter(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int totalParameter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    totalParameter += findEachCellParameter(grid, m, n, i, j);     
                }
            }
        }   
        return totalParameter;  
    }
}