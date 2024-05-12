class Solution {
    public int[][] largestLocal(int[][] grid) {

        int n = grid.length;

        int[][] arr = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                arr[i][j] = maxValueInMatrix(grid, i, i+2, j, j + 2);
            }
        }
        // System.out.println("arr : " + Arrays.deepToString(arr));
        return arr;
    }

    public int maxValueInMatrix(int[][] grid, int rowStart, int rowEnd, int columnStart, int columnEnd) {

        int maxvalue = grid[rowStart][columnStart];

        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = columnStart; j <= columnEnd; j++) {
                maxvalue = Math.max(maxvalue, grid[i][j]);
            }
        }

        return maxvalue;
    }
}