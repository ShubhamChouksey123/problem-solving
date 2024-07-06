class Solution {
    
    public int uniquePathsUtil1(int x, int y) {
        if(x == 0 || y == 0){
            return 1;
        }
        return uniquePathsUtil1(x-1, y) + uniquePathsUtil1(x, y-1); 
    }

    public int uniquePathsUtil(int x, int y, int[][] paths) {
        if(x == 0 || y == 0){
            return 1;
        }
        if(paths[x][y] != -1){
            return paths[x][y];
        }
        paths[x][y] = uniquePathsUtil(x-1, y, paths) + uniquePathsUtil(x, y-1, paths);
        return paths[x][y]; 
    }
    
    public int uniquePaths(int m, int n) {
        // return uniquePathsUtil1(m-1, n-1);


        int[][] paths = new int[m][n];
        for(int[] arr : paths){
            Arrays.fill(arr, -1);
        }
        
        return uniquePathsUtil(m-1, n-1, paths);
    }
}