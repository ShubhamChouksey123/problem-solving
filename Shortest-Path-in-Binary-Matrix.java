1class Solution {
2
3    private static final int[][] DIRECTIONS = new int[][]{
4        {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}
5    };
6
7    private boolean liesInRange(int n, int m , int x, int y){
8        if(x >= 0 && x < n && y >= 0 && y < m){
9            return true;
10        }
11        return false;
12    }
13
14
15
16    public int shortestPathBinaryMatrix(int[][] grid) {
17        int n = grid.length;
18        int m = grid[0].length;
19        int depth = -1;
20        boolean[][] visited = new boolean[n][m];
21
22        
23
24        Deque<int[]> queue = new ArrayDeque<>();
25        if(grid[0][0] == 0){
26            queue.add(new int[]{0, 0, 1});
27        }
28        
29
30        while(!queue.isEmpty()){
31            int[] element = queue.pollFirst();
32            int x = element[0], y = element[1], curDepth = element[2]; 
33            if(x == n-1 && y == m-1){
34                depth = curDepth;
35                break;
36            }
37            for(int i = 0 ; i < 8 ; i++){
38                int x1 = x + DIRECTIONS[i][0];
39                int y1 = y + DIRECTIONS[i][1];
40                if(liesInRange(n, m , x1, y1) && grid[x1][y1] == 0 && !visited[x1][y1]){
41                    visited[x1][y1] = true;
42                    queue.offerLast(new int[]{x1, y1, curDepth + 1});
43                    
44                }
45            }
46
47        }
48
49        return depth;
50        
51    }
52}