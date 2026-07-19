class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    private int dfs(int[][] matrix, int[][] state, int[][] maxIncreasingPath, int n, int m, int x, int y){

        if(state[x][y] == 1) return 0;
        if(state[x][y] == 2) return maxIncreasingPath[x][y];

        state[x][y] = 1;
        
        int maxInnerLength = 0;
        for(int[] direction : DIRECTIONS){
            int x1 = x + direction[0];
            int y1 = y + direction[1];

            if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;
            if(state[x1][y1] == 1) continue;
            if(matrix[x1][y1] <= matrix[x][y]) continue;

            int innerLength = dfs(matrix, state, maxIncreasingPath, n, m, x1, y1);
            maxInnerLength = Math.max(innerLength, maxInnerLength);
        }

        int maxLength = 1 + maxInnerLength;

        state[x][y] = 2;
        maxIncreasingPath[x][y] = maxLength;
        return maxLength;
    }

    public int longestIncreasingPath(int[][] matrix) {

        int n = matrix.length, m = matrix[0].length;
        /**
            0 => unvisited, 1 => visiting and 2 => visited 
         */
        int[][] state = new int[n][m];  
        int[][] maxIncreasingPath = new int[n][m];  
        for(int[] row : state){
            Arrays.fill(row, 0);
        }  
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(state[i][j] == 0){
                    dfs(matrix, state, maxIncreasingPath, n, m, i, j);
                }
            }
        }

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                ans = Math.max(maxIncreasingPath[i][j], ans);
            }
        }
        return ans;

    }
}