class Solution {

    private final int[][] DIRECTIONS = new int[][]{
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    
    public int minCost(int[][] grid) {

        int n = grid.length, m = grid[0].length;

        int[][] minCost = new int[n][m];
        for(int[] row : minCost){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // 1/0 queue containing {x, y, cost}
        Deque<int[]> queue = new ArrayDeque<>();
        minCost[0][0] = 0;
        queue.offerLast(new int[]{0, 0, 0});

        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int x = top[0], y = top[1], cost = top[2];
            
            if(x == n - 1 && y == m - 1) return cost;
            if(minCost[x][y] < cost) continue;

            for(int i = 0 ; i < 4 ; i++){
                int x1 = x + DIRECTIONS[i][0];
                int y1 = y + DIRECTIONS[i][1];

                if(x1 < 0 || x1 == n || y1 < 0 || y1 == m) continue;

                int newCost = (grid[x][y] == i + 1) ? cost : cost + 1; 
                if(minCost[x1][y1] > newCost){
                    minCost[x1][y1] = newCost;
                    if(newCost == cost){
                        queue.offerFirst(new int[]{x1, y1, cost});
                    }
                    else{
                        queue.offerLast(new int[]{x1, y1, cost + 1});
                    }
                }  
            }
        }

        return -1;
        
    }
}