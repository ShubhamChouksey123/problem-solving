class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    private boolean liesInRange(int m, int n, int x, int y){
        if(x >= 0 && x < m && y >= 0 && y < n){
            return true;
        }
        return false;
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        Queue<Integer[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++ ){
                if(mat[i][j] == 0){
                    ans[i][j] = 0;
                    for(int[] direction : DIRECTIONS){
                        int xNew = i + direction[0];
                        int yNew = j + direction[1];
                        if(liesInRange(m, n, xNew, yNew) && mat[xNew][yNew] == 1 && !visited[xNew][yNew]){
                            visited[xNew][yNew] = true;
                            queue.add(new Integer[]{xNew, yNew, 1});
                        }
                    }
                } 
            }
        }

        while(!queue.isEmpty()){
            Integer[] top = queue.poll();
            ans[top[0]][top[1]] = top[2];

            for(int[] direction : DIRECTIONS){
                int xNew = top[0] + direction[0];
                int yNew = top[1] + direction[1];
                if(liesInRange(m, n, xNew, yNew) && mat[xNew][yNew] == 1 && !visited[xNew][yNew]){
                    visited[xNew][yNew] = true;
                    queue.add(new Integer[]{xNew, yNew, top[2] + 1});
                }
            }
            
        }
        return ans;
    }
}