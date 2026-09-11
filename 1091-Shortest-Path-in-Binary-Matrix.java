class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1,0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}
    };


    public int bfs(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        if(grid[0][0] == 1) return -1;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        int a = 0, b = 0, dist = -1;
        while(!queue.isEmpty()){

            int[] top = queue.pollFirst();
            a = top[0]; b = top[1]; dist = top[2];

            if(a == n - 1 && b == m - 1) return dist + 1;

            for(int[] direction : DIRECTIONS){
                int x = a + direction[0];
                int y = b + direction[1];

                if(x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 1|| visited[x][y]) continue;

                visited[x][y] = true;
                queue.offerLast(new int[]{x, y, dist + 1});
            } 
        }
        return -1;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        
        return bfs(grid) ;

    }
}