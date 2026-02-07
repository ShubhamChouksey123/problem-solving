1class Solution {
2    private final int[][] directions = new int[][]{
3        {1,0}, {0, 1}, {-1, 0}, {0, -1}
4    }; 
5
6    private boolean liesInRange(int n, int m, int x, int y){
7        if(x >= 0 && x < n && y >= 0 && y < m)
8            return true;
9        return false;
10    }
11
12    private void addAllNeighbours(int[][] grid, boolean[][] visited, Queue<int[]> queue, int x, int y, int distance){
13
14        int n = grid.length, m = grid[0].length;
15        for(int i = 0 ; i < 4 ; i++){
16            int x1 = x + directions[i][0];
17            int y1 = y + directions[i][1];
18            if(liesInRange(n, m, x1, y1) && grid[x1][y1] == 0 && !visited[x1][y1]){
19                visited[x1][y1] = true;
20                queue.add(new int[]{x1, y1, distance});
21            }
22        }
23
24    }
25    
26    public int maxDistance(int[][] grid) {
27
28        int n = grid.length, m = grid[0].length;
29        boolean[][] visited = new boolean[n][m];
30        Queue<int[]> queue = new ArrayDeque<>();
31
32
33        int landCount = 0;
34        for(int i = 0 ; i < n ; i++){
35            for(int j = 0 ; j < m ; j++){
36                if(grid[i][j] == 1){
37                    visited[i][j] = true; landCount++;
38                    queue.add(new int[]{i, j, 0});
39                }
40            }
41        }
42
43        if(landCount == n*m || landCount == 0){
44            return -1;
45        }
46
47        int dist = -1;
48        while(!queue.isEmpty()){
49            int[] node = queue.poll();
50            int x = node[0], y = node[1];
51            dist = node[2];
52            addAllNeighbours(grid, visited, queue, x, y, dist + 1);
53        }
54
55        return dist;
56        
57    }
58}