class Solution {

    private boolean liesInRange(int m, int n, int x, int y) {
        if (x >= 0 && y >= 0 && x < m && y < n)
            return true;
        return false;
    }

    private int countNeighbourOnes(int[][] board, int m, int n, int x, int y) {

        int count = 0;
        if (liesInRange(m, n, x + 1, y) && (board[x + 1][y] == 1 || board[x + 1][y] == 10)) {
            count++;
        }

        if (liesInRange(m, n, x + 1, y + 1) && (board[x + 1][y + 1] == 1 || board[x + 1][y + 1] == 10)) {
            count++;
        }

        if (liesInRange(m, n, x, y + 1) && (board[x][y + 1] == 1 || board[x][y + 1] == 10)) {
            count++;
        }

        if (liesInRange(m, n, x - 1, y + 1) && (board[x - 1][y + 1] == 1 || board[x - 1][y + 1] == 10)) {
            count++;
        }

        if (liesInRange(m, n, x - 1, y) && (board[x - 1][y] == 1 || board[x - 1][y] == 10)) {
            count++;
        }

        if (liesInRange(m, n, x - 1, y - 1) && (board[x - 1][y - 1] == 1 || board[x - 1][y - 1] == 10)) {
            count++;
        }

        if (liesInRange(m, n, x, y - 1) && (board[x][y - 1] == 1 || board[x][y - 1] == 10)) {
            count++;
        }

        if (liesInRange(m, n, x + 1, y - 1) && (board[x + 1][y - 1] == 1 || board[x + 1][y - 1] == 10)) {
            count++;
        }

        return count;

    }

    private int countNeighbourZeros(int[][] board, int m, int n, int x, int y) {

        int count = 0;
        if (liesInRange(m, n, x + 1, y) && (board[x + 1][y] == 1 || board[x + 1][y] == 10)) {
            count++;
        }

        if (liesInRange(m, n, x + 1, y + 1) && (board[x + 1][y + 1] == 1 || board[x + 1][y + 1] == 10)) {
            count++;
        }

        if (liesInRange(m, n, x, y + 1) && (board[x][y + 1] == 1 || board[x][y + 1] == 10)) {
            count++;
        }

        if (liesInRange(m, n, x - 1, y + 1) && (board[x - 1][y + 1] == 1 || board[x - 1][y + 1] == 10)) {
            count++;
        }

        if (liesInRange(m, n, x - 1, y) && (board[x - 1][y] == 1 || board[x - 1][y] == 10)) {
            count++;
        }

        if (liesInRange(m, n, x - 1, y - 1) && (board[x - 1][y - 1] == 1 || board[x - 1][y - 1] == 10)) {
            count++;
        }

        if (liesInRange(m, n, x, y - 1) && (board[x][y - 1] == 1 || board[x][y - 1] == 10)) {
            count++;
        }

        if (liesInRange(m, n, x + 1, y - 1) && (board[x + 1][y - 1] == 1 || board[x + 1][y - 1] == 10)) {
            count++;
        }

        return count;

    }

    private void updateOne(int[][] board, int m, int n, int x, int y) {

        int countOnes = countNeighbourOnes(board, m, n, x, y);

        /**
         * earlier 1 and now also one
         * 1 -> 11
         */
        if (countOnes < 2) {
            board[x][y] = 10;
        }
        if (countOnes == 2 || countOnes == 3) {
            return;
        }

        /**
         * earlier one and now zero
         * 1 -> 10
         */
        if (countOnes > 3) {
            board[x][y] = 10;
        }

    }

    private void updateZero(int[][] board, int m, int n, int x, int y) {

        int countZeros = countNeighbourZeros(board, m, n, x, y);

        /**
         * earlier 0 and now also 1
         * 0 -> 21
         */
        if (countZeros == 3) {
            board[x][y] = 21;
        }

    }

    private void updateOnes(int[][] board, int m, int n) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    updateOne(board, m, n, i, j);
                }
            }
        }

    }

    private void updateZeros(int[][] board, int m, int n) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    updateZero(board, m, n, i, j);
                }
            }
        }

    }

    private void fixToCorrectNom(int[][] board, int m, int n) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 11) {
                    board[i][j] = 1;
                } else if (board[i][j] == 10) {
                    board[i][j] = 0;
                } else if (board[i][j] == 20) {
                    board[i][j] = 0;
                } else if (board[i][j] == 21) {
                    board[i][j] = 1;
                }
            }
        }

    }

    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        updateOnes(board, m, n);
        updateZeros(board, m, n);

        fixToCorrectNom(board, m, n);
        
    }
}