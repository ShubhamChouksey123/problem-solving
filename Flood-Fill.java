1class Solution {
2
3    private static int n;
4    private static int m;
5    private static final int[][] DIRECTIONS = new int[][]{
6        {1,0}, {0, 1}, {-1, 0}, {0,-1}
7    };
8
9
10    private void dfs(int[][] finalImage, boolean[][] visited, int x, int y, int originalColor, int newColor) {
11        
12        visited[x][y] = true;
13        finalImage[x][y] = newColor;
14
15        for(int[] direction : DIRECTIONS){
16            int x1 = x + direction[0];
17            int y1 = y + direction[1];
18            if(x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && !visited[x1][y1] && finalImage[x1][y1] == originalColor){
19                dfs(finalImage, visited, x1 , y1, originalColor, newColor);
20            }
21        }
22    }
23    
24    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
25        n = image.length;
26        m = image[0].length;
27
28        int[][] finalImage = new int[n][m];
29        for(int i = 0 ; i < n ; i++){
30            for(int j = 0 ; j < m ; j++){
31                finalImage[i][j] = image[i][j];
32            }
33        }
34
35        boolean[][] visited = new boolean[n][m];
36        dfs(finalImage, visited, sr, sc, image[sr][sc], color);  
37
38        return finalImage;
39    }
40}