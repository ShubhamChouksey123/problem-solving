class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;
        k = k % (n * m);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            ans.add(new ArrayList<>());
            for(int j = 0 ; j < m ; j++){
                ans.get(i).add(0);
            }
        }
        
        int row = 0, col = 0, flatIndex = 0, newflatIndex = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                flatIndex = (i * m) + j;
                newflatIndex = (flatIndex + k ) % (n * m);
                row = newflatIndex / m;
                col = newflatIndex % m;
                ans.get(row).set(col, grid[i][j]);
            }
        }
        return ans;
    }
}