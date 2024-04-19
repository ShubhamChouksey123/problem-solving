class Solution {

    public boolean[] occurrence = new boolean[]{false, false, false, false,
            false, false, false, false,
            false, false};

    private void clearOccurrence() {
        Arrays.fill(occurrence, false);
    }

    
    
    private boolean isValidRow(char[][] board, int m) {

        clearOccurrence();
        for (int i = 0; i < 9; i++) {
            int value = board[m][i] - '0';
            if (board[m][i] == '.') {
                continue;
            }

            if (occurrence[value]) {
                return false;
            }
            occurrence[value] = true;
        }

        System.out.println("true for row : " + m);
        return true;

    }


    private boolean isValidColumn(char[][] board, int n) {

        clearOccurrence();
        for (int i = 0; i < 9; i++) {
            int value = board[i][n] - '0';
            if (board[i][n] == '.') {
                continue;
            }

            if (occurrence[value]) {
                return false;
            }
            occurrence[value] = true;
        }
        return true;
    }

    private boolean isValidSquare(char[][] board, int rowOffset, int columnOffset) {

        clearOccurrence();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = board[rowOffset + i][columnOffset + j] - '0';
                if (board[rowOffset + i][columnOffset + j] == '.') {
                    continue;
                }

                if (occurrence[value]) {
                    return false;
                }
                occurrence[value] = true;
            }
        }
        return true;
    }
  
    
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        
        for (int i = 0; i < m; i++) {
            System.out.println("checking for row : " + i);
            if (!isValidRow(board, i)) {
                return false;
            }
        }

        for (int j = 0; j < n; j++) {
            if (!isValidColumn(board, j)) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValidSquare(board, 3 * i, 3 * j)) {
                    return false;
                }
            }

        }
        return true;
        
    }
}