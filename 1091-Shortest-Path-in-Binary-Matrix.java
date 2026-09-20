class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1,-1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length, m = grid[0].length;

        if(grid[0][0] == 1) return -1;

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] top = queue.pollFirst();
            int u = top[0], v = top[1], step = top[2];

            if(u == n - 1 && v == m - 1) return step;
            
            for(int[] direction : DIRECTIONS){
                int x = u + direction[0];
                int y = v + direction[1];

                if(x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || grid[x][y] == 1) continue;

                queue.offer(new int[]{x, y, step + 1});
                visited[x][y] = true;

            }
        }
        return -1;
    }
}