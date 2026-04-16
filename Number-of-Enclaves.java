1class Solution {
2
3    private int N;
4    private int M;
5    private static final int[][] DIRECTIONS = new int[][]{
6        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
7    };
8
9    private void dfs(int[][] grid, boolean[][] visited, int x, int y){
10
11        if(grid[x][y] == 0)
12            return;
13
14        visited[x][y] = true;
15
16        for(int[] direction : DIRECTIONS){
17            int x1 = x + direction[0];
18            int y1 = y + direction[1];
19
20            if(x1 >= 0 && x1 < N && y1 >= 0 && y1 < M && grid[x1][y1] == 1 && !visited[x1][y1]){
21                dfs(grid, visited, x1, y1);
22            }
23        }
24    }
25
26    public int numEnclaves(int[][] grid) {
27
28        N = grid.length; M = grid[0].length;
29        boolean[][] visited = new boolean[N][M];
30
31        for(int j = 0 ; j < M ; j++){
32            dfs(grid, visited, 0, j);
33            dfs(grid, visited, N-1, j);
34        }
35
36        for(int i = 0 ; i < N ; i++){
37            dfs(grid, visited, i, 0);
38            dfs(grid, visited, i, M-1);
39        }
40        int count = 0;
41        for(int i = 0 ; i < N ; i++){
42            for(int j = 0 ; j < M ; j++){
43                if(grid[i][j] == 1 && !visited[i][j]){
44                    count++;
45                }
46            }
47        }
48        return count;
49        
50    }
51}