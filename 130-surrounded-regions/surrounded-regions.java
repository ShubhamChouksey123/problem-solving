class Solution {

    private boolean canReachEnd(char[][] board, int m, int n, boolean[][] visited, int x, int y) {

        if (x < 0 || x >= m || y < 0 || y >= n)
            return true;

        if (board[x][y] == 'X')
            return false;

        if (visited[x][y])
            return false;

        visited[x][y] = true;

        return canReachEnd(board, m, n, visited, x + 1, y) ||
                canReachEnd(board, m, n, visited, x - 1, y) ||
                canReachEnd(board, m, n, visited, x, y + 1) ||
                canReachEnd(board, m, n, visited, x, y - 1);

    }

    private void flipToB(char[][] board, int m, int n, boolean[][] visitedDFS, int x, int y) {

        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == 'X' || board[x][y] == 'b' || board[x][y] == 'a')
            return;

        if (visitedDFS[x][y])
            return;

        visitedDFS[x][y] = true;
        board[x][y] = 'b';

        flipToB(board, m, n, visitedDFS, x + 1, y);
        flipToB(board, m, n, visitedDFS, x - 1, y);
        flipToB(board, m, n, visitedDFS, x, y + 1);
        flipToB(board, m, n, visitedDFS, x, y - 1);

    }

    private void flipToA(char[][] board, int m, int n, boolean[][] visitedDFS, int x, int y) {

        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == 'X' || board[x][y] == 'b' || board[x][y] == 'a')
            return;

        if (visitedDFS[x][y])
            return;

        visitedDFS[x][y] = true;
        board[x][y] = 'a';

        flipToA(board, m, n, visitedDFS, x + 1, y);
        flipToA(board, m, n, visitedDFS, x - 1, y);
        flipToA(board, m, n, visitedDFS, x, y + 1);
        flipToA(board, m, n, visitedDFS, x, y - 1);

    }

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {

                if (board[i][j] == 'O' && !visited[i][j]) {

                    boolean[][] visitedDFS = new boolean[m][n];
                    if (!canReachEnd(board, m, n, visited, i, j)) {
                        flipToB(board, m, n, visitedDFS, i, j);
                    } else {
                        flipToA(board, m, n, visitedDFS, i, j);
                    }

                }

            }
        }

        // print(board);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'b') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == 'a') {
                    board[i][j] = 'O';
                }
            }
        }
        // System.out.println();
        // print(board);
    }
}