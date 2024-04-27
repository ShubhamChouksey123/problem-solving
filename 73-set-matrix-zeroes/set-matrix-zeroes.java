class Solution {

        public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[] isRowZero = new boolean[m];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    isRowZero[i] = true;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                setEntireColumnZero(matrix, j, m);
            }
        }

        for (int i = 0; i < m; i++) {
            if (isRowZero[i]) {
                setEntireRowZero(matrix, i, n);
            }
        }


    }

    private void setEntireColumnZero(int[][] matrix, int column, int m) {

        for (int i = 0; i < m; i++) {
            matrix[i][column] = 0;
        }
    }

    private void setEntireRowZero(int[][] matrix, int row, int n) {
        for (int j = 0; j < n; j++) {
            matrix[row][j] = 0;
        }
    }

}