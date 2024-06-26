class Solution {
    private void flipEntireRow(int[][] grid, int row, int m, int n) {

        for (int j = 0; j < n; j++) {
            if (grid[row][j] == 0) {
                grid[row][j] = 1;
            } else {
                grid[row][j] = 0;
            }
        }
    }

    private boolean isColumnFlipRequired(int[][] grid, int column, int m, int n) {

        int zeroCount = 0;
        for (int i = 0; i < m; i++) {
            if (grid[i][column] == 0)
                zeroCount++;
        }
        return zeroCount > m / 2;
    }


    private void flipEntireColumn(int[][] grid, int column, int m, int n) {

        for (int i = 0; i < m; i++) {
            if (grid[i][column] == 0) {
                grid[i][column] = 1;
            } else {
                grid[i][column] = 0;
            }
        }
    }

    private int calculateNumericalValue(int[][] grid, int row, int m, int n) {

        int sum = 0;
        for (int j = 0; j < n; j++) {
            if (grid[row][j] == 1) {
                sum = sum + (int) Math.pow(2, n - j - 1);
            }
        }
        return sum;
    }

    /**
     * i and m
     * j and n
     *
     * @param grid
     * @return
     */
    public int matrixScore(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                flipEntireRow(grid, i, m, n);
            }
        }


        for (int j = 0; j < n; j++) {
            if (isColumnFlipRequired(grid, j, m, n)) {
                flipEntireColumn(grid, j, m, n);
            }
        }


        int totalScore = 0;
        for (int i = 0; i < m; i++) {
            totalScore += calculateNumericalValue(grid, i, m, n);
        }

        return totalScore;
    }
}