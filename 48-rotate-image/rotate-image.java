class Solution {
        private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }

    private void transpose(int[][] matrix) {

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }


    private void mirror(int[][] matrix, int row) {

        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            swap(matrix, row, i, row, n - i - 1);
        }
    }

    public void rotate(int[][] matrix) {
        transpose(matrix);

        for (int row = 0; row < matrix.length; row++) {
            mirror(matrix, row);
        }
    }
}