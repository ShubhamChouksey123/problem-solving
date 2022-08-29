class Solution {
    
    private boolean liesInRange(int x, int y, int n, int m) { 
        if(x >=0 && x < n && y >=0 && y < m)
            return true;
        return false;
    } 
    
    /** Mark all visited nodes from the crrent Node */
    private void markeVisitedNode(char[][] grid, int x, int y, int n, int m) {
        
        grid[x][y] = '2';
        
        if(liesInRange(x + 1, y,  n,  m) && grid[x+1][y] == '1'){
            markeVisitedNode(grid,  x+1,  y,  n,  m);
        }
        if(liesInRange(x, y+1,  n,  m) && grid[x][y+1] == '1'){
            markeVisitedNode(grid,  x,  y+1,  n,  m);
        }
        if(liesInRange(x -1, y,  n,  m) && grid[x-1][y] == '1'){
            markeVisitedNode(grid,  x-1,  y,  n,  m);
        }
        if(liesInRange(x , y-1,  n,  m) && grid[x][y-1] == '1'){
            markeVisitedNode(grid,  x,  y-1,  n,  m);
        }
        
    } 
    
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1'){
                    markeVisitedNode( grid,  i,  j,  n, m);
                    count++;
                }
            }
        }
        
        return count;
        
    }
}