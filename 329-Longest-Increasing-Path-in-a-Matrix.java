class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    private int dfs(int[][] matrix, int n, int m, Integer[][] longestIncreaingPath, int a, int b) {

        if(longestIncreaingPath[a][b] != null) return longestIncreaingPath[a][b];
        
        int maxNeighboutPathLength = 0;
        for(int[] direction : DIRECTIONS){
            int x = a + direction[0];
            int y = b + direction[1];

            if(x < 0 || x >= n || y < 0 || y >= m) continue;

            if(matrix[x][y] > matrix[a][b]){
                int neighboutPathLength = dfs(matrix, n, m, longestIncreaingPath, x, y);
                maxNeighboutPathLength = Math.max(maxNeighboutPathLength, neighboutPathLength);
            }
        }

        longestIncreaingPath[a][b] = 1 + maxNeighboutPathLength;
        return 1 + maxNeighboutPathLength;
    }    

    public int longestIncreasingPath(int[][] matrix) {
        
        int n = matrix.length, m = matrix[0].length;
        Integer[][] longestIncreaingPath = new Integer[n][m];

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(longestIncreaingPath[i][j] == null){
                    dfs(matrix, n, m, longestIncreaingPath, i, j); 
                }
            }
        }

        int maxPathLength = 0;
        for(int i = 0 ; i < n; i++){
            System.out.println(Arrays.toString(longestIncreaingPath[i]));
            for(int j = 0; j < m ; j++){
                maxPathLength = Math.max(maxPathLength, longestIncreaingPath[i][j]);
            }
        }
        return maxPathLength;
    }
}