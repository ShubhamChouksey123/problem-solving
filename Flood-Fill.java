1class Solution {
2
3    private static final int[][] DIRECTIONS = new int[][]{
4        {1,0}, {0, 1}, {-1, 0}, {0,-1}
5    };
6
7
8    private void dfs(int[][] image, boolean[][] visited, int x, int y, int originalColor, int newColor) {
9        
10        visited[x][y] = true;
11        image[x][y] = newColor;
12
13        for(int[] direction : DIRECTIONS){
14            int x1 = x + direction[0];
15            int y1 = y + direction[1];
16            if(x1 >= 0 && x1 < image.length && y1 >= 0 && y1 < image[0].length && !visited[x1][y1] && image[x1][y1] == originalColor){
17                dfs(image, visited, x1 , y1, originalColor, newColor);
18            }
19        }
20    }
21    
22    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
23
24
25        int originalColor = image[sr][sc];
26        if(originalColor != newColor){
27            boolean[][] visited = new boolean[image.length][image[0].length];
28            dfs(image, visited, sr, sc, originalColor, newColor); 
29        }
30
31        return image;
32    }
33}