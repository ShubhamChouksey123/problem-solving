class Solution {

    private int totalNQueens = 0;
    private boolean liesInRange(int n, int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) {
            return true;
        }
        return false;
    }

    private boolean isPositionSafe(int n, boolean[][] chess, int x, int y) {

        for (int j = 0; j < n; j++) {
            if (chess[x][j]) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (chess[i][y]) {
                return false;
            }
        }

        int startX = x + y;
        int startY = 0;

        while (startX >= 0) {
            if (liesInRange(n, startX, startY) && chess[startX][startY]) {
                return false;
            }
            startX--;
            startY++;
        }

        startX = x - y;
        startY = 0;

        while (startX < n) {
            if (liesInRange(n, startX, startY) && chess[startX][startY]) {
                return false;
            }
            startX++;
            startY++;
        }

        return true;
    }

    private void countTotalNQueens(int n, boolean[][] chess, int column) {

        if (column == n) {
            totalNQueens++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isPositionSafe(n, chess, i, column)) {
                chess[i][column] = true;
                countTotalNQueens(n, chess, column + 1);
                chess[i][column] = false;
            }
        }
    }

    public int totalNQueens(int n) {

        totalNQueens = 0;
        countTotalNQueens(n, new boolean[n][n], 0);
        return totalNQueens;
    }

}