class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int n = grid.length, m = grid[0].length;
        k = k % (n*m);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            List<Integer> inner = new ArrayList<>();
            for(int j = 0 ; j < m ; j++){
                inner.add(-1);
            }
            ans.add(inner);
        } 


        int row = 0, newRow = 0, col = 0, newCol = 0;
        int newI = 0;

        for(int i = 1 ; i <= n * m ; i++){
            row = ((i-1) / m);
            col = (i-1) % m;
            newI = (i + k) % (n * m);
            newRow = ((i + k-1) / m) % n;
            newCol = (i + k-1) % m;
            
            ans.get(newRow).set(newCol, grid[row][col]);
        } 
        return ans;
    }
}