class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;
        int[][] minEffort = new int[n][m];
        for(int[] row : minEffort){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        queue.add(new int[]{0, 0, 0});


        while(!queue.isEmpty()){

            int[] top = queue.poll();
            int a = top[0], b = top[1], w = top[2];

            if(minEffort[a][b] < w) continue;
            minEffort[a][b] = w;

            for(int[] direction : DIRECTIONS){
                
                int x = a + direction[0];
                int y = b + direction[1];
                if(x < 0 || x >= n || y < 0 || y >= m) continue;

                int thisPathEffort = Math.max(minEffort[a][b], Math.abs(heights[x][y] - heights[a][b])); 

                if(minEffort[x][y] > thisPathEffort){
                    minEffort[x][y] = thisPathEffort;
                    queue.add(new int[]{x, y, thisPathEffort});   
                }
            }

        }
        return minEffort[n-1][m-1];
    }
}