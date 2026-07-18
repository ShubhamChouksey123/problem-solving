class Solution {
    
    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}
    }; 

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;


        boolean[][] visited = new boolean[n][n];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[]{0, 0, 1});
        visited[0][0] = true;
        int x = 0, y = 0;
        int ans = -1;

        while(!queue.isEmpty()){
            int[] element = queue.pollFirst();  
            
            x = element[0]; y = element[1];
            if(x == n - 1 && y == n - 1){
                ans = element[2]; break;
            }

            for(int[] direction : DIRECTIONS ){
                int nextRow = x + direction[0];
                int nextColumn = y + direction[1];
                
                if(nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n 
                    || visited[nextRow][nextColumn] || grid[nextRow][nextColumn] == 1
                ) continue;
            
                visited[nextRow][nextColumn] = true;
                queue.offerLast(new int[]{nextRow, nextColumn, element[2] + 1});
            }
        }   
        return ans;

    }
}