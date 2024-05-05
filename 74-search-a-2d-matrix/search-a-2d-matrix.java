class Solution {
    
    private int getRowNumber(int[][] matrix, int target, int m, int n, int start, int end) {


        if (end - start == 1) {
            if (target < matrix[end][0]) {
                return start;
            } else {
                return end;
            }
        }

        if (start == end) {
            return start;
        }

        int mid = (start + end) / 2;

        if (target == matrix[mid][0]) {
            return mid;
        } else if (target < matrix[mid][0]) {
            return getRowNumber(matrix, target, m, n, start, mid - 1);
        }
        return getRowNumber(matrix, target, m, n, mid, end);

    }

    private boolean isExistInRow(int[][] matrix, int target, int row, int start, int end) {

        if (start == end) {
            if (target == matrix[row][start]) {
                return true;
            }
            return false;
        }

        int mid = (start + end) / 2;

        if (target == matrix[row][mid]) {
            return true;
        } else if (target < matrix[row][mid]) {
            return isExistInRow(matrix, target, row, start, mid);
        }
        return isExistInRow(matrix, target, row, mid + 1, end);

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }

        int row = getRowNumber(matrix, target, m, n, 0, m - 1);
        System.out.println("row : " + row);

        return isExistInRow(matrix, target, row, 0, n - 1);

    }
}