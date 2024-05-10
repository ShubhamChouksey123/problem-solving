class Solution {

    public boolean liesInRange(int m, int n, int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n)
            return true;
        return false;
    }

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] pathSum = new int[m][n];
        pathSum[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                int val = grid[i][j];
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                if (liesInRange(m, n, i - 1, j)) {
                    a = pathSum[i - 1][j] + val;
                }
                if (liesInRange(m, n, i, j - 1)) {
                    b = pathSum[i][j - 1] + +val;
                }
                pathSum[i][j] = Math.min(a, b);
            }
        }

        System.out.println("pathSum  : " + Arrays.deepToString(pathSum));
        return pathSum[m - 1][n - 1];

    }
}