1class Solution {
2
3    private final int[][] directions = new int[][]{
4        // {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}
5        {0, 1}, {1, 0},  {0, -1}, {-1, 0}
6    };
7
8    private boolean liesInRange(int n, int m, int x, int y){
9        if(x >= 0 && x < n && y >= 0 && y < m){
10            return true;
11        }
12        return false;
13    }   
14
15
16    private void addAllNeighBours(int[][] grid, int x, int y, boolean[][] visited, Queue<int[]> queue, int time){
17
18        int n = grid.length, m = grid[0].length;
19        for(int i = 0 ; i < 4; i++){
20            int x1 = x + directions[i][0];
21            int y1 = y + directions[i][1];
22
23            if(liesInRange(n, m, x1, y1) && grid[x1][y1] == 1 && !visited[x1][y1]){
24                visited[x1][y1] = true;
25                queue.offer(new int[]{x1, y1, time});
26            }
27        }
28    }
29
30    public int orangesRotting(int[][] grid) {
31
32        int n = grid.length, m = grid[0].length;
33        boolean[][] visited = new boolean[n][m];
34
35        Queue<int[]> queue = new ArrayDeque<>();
36
37        for(int i = 0 ; i < n ; i++){
38            for(int j = 0 ; j < m ; j++){
39                if(grid[i][j] == 2){
40                    visited[i][j] = true;
41                    queue.add(new int[]{i, j, 0});
42                }
43            }
44        }
45
46        int time = 0;
47        while(!queue.isEmpty()){
48            int[] element = queue.poll();
49            int x = element[0], y = element[1];
50            time = element[2];
51            addAllNeighBours(grid, x, y, visited, queue, time + 1);
52        }
53
54        for(int i = 0 ; i < n ; i++){
55            for(int j = 0 ; j < m ; j++){
56                if(grid[i][j] == 1 && !visited[i][j]){
57                    return -1;
58                }
59            }
60        }
61
62        return time;
63        
64    }
65}