class Solution {

    private final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    private boolean liesInRange(int m, int n, int x, int y){
        if(x >= 0 && x < m && y >= 0 && y < n ){
            return true;
        }
        return false;
    }

    /**
    * DFS from (sc, sc)
     */
    public void floodFillUtil(int[][] image, int m, int n, int sr, int sc, int color, int originalColor, boolean[][] visited) {        
          
        image[sr][sc] = color;

        for(int[] direction : DIRECTIONS){
            int x = sr + direction[0] ;
            int y = sc + direction[1] ;
            if(liesInRange(m, n, x, y) && !visited[x][y] && image[x][y] == originalColor){
                visited[x][y] = true;
                floodFillUtil(image, m, n, x, y, color, originalColor, visited) ;
            }
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length, n = image[0].length;
        boolean[][] visited = new boolean[m][n];  

        visited[sr][sc] = true;
        floodFillUtil(image, m, n, sr, sc, color, image[sr][sc],visited);

        return image;
    }
}