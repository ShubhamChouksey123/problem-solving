1class Solution {
2    
3    private int N;
4    private int M;
5    private static final int[][] DIRECTIONS = new int[][]{
6        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
7    }; 
8
9    public void dfs(int[][] grid, int x, int y, int newColor, int[][] color, boolean[][] visited) {
10
11        visited[x][y] = true;
12        if(x == 0 || x == N - 1 || y == 0 || y == M - 1){
13            color[x][y] = newColor;   
14        }
15
16        if( (x + 1 < N && grid[x][y] != grid[x+1][y] ) ||
17            (y + 1 < M && grid[x][y] != grid[x][y+1] ) ||
18            (x - 1 >= 0 && grid[x][y] != grid[x-1][y] ) ||
19            (y - 1 >= 0 && grid[x][y] != grid[x][y-1] ) 
20        ){
21            color[x][y] = newColor;     
22        }
23
24
25        for(int[] direction : DIRECTIONS){
26            int x1 = x + direction[0];
27            int y1 = y + direction[1];
28
29            if( x1 >= 0 && x1 < N && y1 >= 0. && y1 < M && !visited[x1][y1] && grid[x][y] == grid[x1][y1]){
30                dfs(grid, x1, y1, newColor, color, visited);
31            }
32        }
33        // visited[x][y] = false;
34    }
35    
36    public int[][] colorBorder(int[][] grid, int row, int col, int newColor) {
37        N = grid.length; M = grid[0].length;
38        int[][] color = new int[N][M];
39        for(int i = 0 ; i < N ; i++){
40            Arrays.fill(color[i], -1);
41        }
42        boolean[][] visited = new boolean[N][M];
43
44        dfs(grid, row, col, newColor, color, visited);
45
46
47        for(int i = 0 ; i < N ; i++){
48            for(int j = 0 ; j < M ; j++){
49                if(color[i][j] == -1){
50                    color[i][j] = grid[i][j];
51                }
52            }
53        }
54        return color;
55
56
57    }
58}