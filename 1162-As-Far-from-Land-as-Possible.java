class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public int maxDistance(int[][] grid) {

        int n = grid[0].length, m = grid[0].length, countOnes = 0;
        Deque<int[]> queue = new ArrayDeque<>();


        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    queue.offerLast(new int[]{i, j, 0});
                    countOnes++;
                }
            }
        }

        if(countOnes == 0 || countOnes == n * m) return -1;

        int a = 0, b = 0, time = 0;
        while(!queue.isEmpty()){
            
            int[] top = queue.pollFirst();
            a = top[0]; b = top[1]; time = top[2];

            for(int[] direction : DIRECTIONS){
                int x = a + direction[0];
                int y = b + direction[1];

                if(x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 1) continue;

                grid[x][y] = 1;
                queue.offerLast(new int[]{x, y, time + 1});
            }
        }

        return time;
    }
}