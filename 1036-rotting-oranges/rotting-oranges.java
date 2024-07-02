class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };

    private boolean liesInRange(int m, int n, int x, int y){
        if( x >= 0 && x < m && y >= 0 && y < n){
            return true;
        }
        return false;
    }


    private int minDistance(int[][] grid, int m, int n, int x, int y){
        System.out.println("BFS from x :" + x + " y : " + y );
        // x, y, distance

        boolean[][] visited = new boolean[m][n];
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{x, y, 0});
        visited[x][y] = true;
        int distance = -1;

        while(!queue.isEmpty()){
            Integer[] top = queue.poll();
            System.out.println("inside x :" + top[0] + " y : " + top[1] );
            System.out.println("grid[top[0]][top[1]] :" + grid[top[0]][top[1]] );
            if(grid[top[0]][top[1]] == 2){
                distance = top[2];
                break;
            }

            for(int[] direction : DIRECTIONS){
                int xNew = top[0] +  direction[0];
                int yNew = top[1] +  direction[1];
                int dist = top[2];

                if(liesInRange(m, n, xNew, yNew) && !visited[xNew][yNew] && grid[xNew][yNew] != 0){
                    visited[xNew][yNew] = true;
                    queue.add(new Integer[]{xNew, yNew, dist+1});
                }
            }
        }
        return distance;
    }


    public int orangesRotting(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        

        int totalTime = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    int distance = minDistance(grid,  m, n, i, j);
                    System.out.println("inside i :" + i + " j : " + j + " distance : " + distance);
                    if(distance == -1){
                        return -1;
                    }
                    totalTime = Math.max(totalTime, distance);
                }
            }
        }
        return totalTime;
    }
}


/**


[[2,1,1],[1,1,0],[0,1,1]]



 */