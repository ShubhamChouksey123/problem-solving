class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length, m = mat[0].length;
        int[][] ans = new int[n][m];

        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 0) {
                    queue.offerLast(new int[]{i, j, 0});
                }
            }
        }

        while(!queue.isEmpty()){

            int[] top = queue.pollFirst();
            int x = top[0], y = top[1], w = top[2];
            if(ans[x][y] != 0 && ans[x][y] < w) continue;

            for(int[] direction : DIRECTIONS){
                int a = x + direction[0];
                int b = y + direction[1];

                if(a < 0 || a >= n || b < 0 || b >= m || mat[a][b] == 0) continue;
                if(ans[a][b] != 0 && ans[a][b] < w + 1) continue;

                ans[a][b] = w + 1;
                queue.offerLast(new int[]{a, b, w + 1});
            }
        }
        return ans;
    }
}