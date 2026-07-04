class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    
    private boolean dfs(List<List<Integer>> grid, int health, int n, int m,  int[][] maxHealthAtCell, int x, int y) {
        
        if(grid.get(x).get(y) == 1) health--;

        if(health <= 0) return false;

        if(maxHealthAtCell[x][y] >= health) return false;
        
        maxHealthAtCell[x][y] = health;
        if(x == n - 1 && y == m - 1) return true;

        
        for(int[] direction : DIRECTIONS){
            int x1 = x + direction[0];
            int y1 = y + direction[1];

            if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;

            if(dfs(grid, health, n, m, maxHealthAtCell, x1, y1)) return true;

        }
        
        return false;
    }
    
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int n = grid.size();
        int m = grid.get(0).size();

        int[][] maxHealthAtCell = new int[n][m];
        for(int[] row : maxHealthAtCell){
            Arrays.fill(row, -1);
        }

        return dfs(grid, health, n, m,  maxHealthAtCell, 0, 0);    
    }
}