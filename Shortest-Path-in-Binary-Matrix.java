1class Solution {
2
3    private final int[][] directions = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
4
5    private boolean liesInRange(int n,int m, int x, int y){
6        if(x >= 0 && x < n && y >= 0 && y < m){
7            return true;
8        }
9        return false;
10    }
11
12    private void addAllNeighBoursInQueue(int[][] grid, int x, int y, boolean[][] visited, Queue<int[]> queue, int len){
13
14        int n = grid.length, m = grid[0].length;
15        for(int i = 0 ; i < 8 ; i++){
16            int x1 = x + directions[i][0];
17            int y1 = y + directions[i][1];
18
19            if(liesInRange(n, m, x1, y1) && grid[x1][y1] == 0 && !visited[x1][y1]){
20                visited[x1][y1] = true;
21                queue.add(new int[]{x1, y1, len});
22            }
23        }
24    }
25
26    public int shortestPathBinaryMatrix(int[][] grid) {
27
28        int n = grid.length, m = grid[0].length;
29        boolean[][] visited = new boolean[n][m];
30
31        Queue<int[]> queue = new ArrayDeque<>();
32        if(grid[0][0] == 0){
33            visited[0][0] = true;
34            queue.add(new int[]{0, 0, 1});
35        }
36
37
38        while(!queue.isEmpty()){
39            int[] node = queue.poll();
40            int x = node[0], y = node[1], len = node[2];
41            
42            
43            if(x == n-1 && y == m-1){
44                return len;
45            }
46
47            addAllNeighBoursInQueue(grid, x, y, visited, queue, len + 1);
48        }
49        return -1;       
50    }
51}