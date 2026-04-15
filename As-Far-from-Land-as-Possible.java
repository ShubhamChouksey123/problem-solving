1class Solution {
2
3    private int N;
4    private int M;
5    private static final int[][] DIRECTIONS = new int[][]{
6        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
7    }; 
8
9    private void addAllNeighbours(int[][] grid, boolean[][] visited, int x, int y, int distance, Deque<int[]> queue){
10        for(int[] direction : DIRECTIONS){
11            int x1 = x + direction[0];
12            int y1 = y + direction[1];
13
14            if(x1 >= 0 && x1 < N && y1 >= 0 && y1 < M && grid[x1][y1] == 0 && !visited[x1][y1]){
15                queue.offerLast(new int[]{x1, y1, distance});
16                visited[x1][y1] = true;
17            }
18        }
19    }
20
21    public int maxDistance(int[][] grid) {
22        N = grid.length; M = grid[0].length;
23        boolean[][] visited = new boolean[N][M];
24
25        Deque<int[]> queue = new ArrayDeque<>();
26        int countLand = 0;
27        
28        for(int i = 0 ; i < N ; i++){
29            for(int j = 0 ; j < M ; j++){
30                if(grid[i][j] == 1){
31                    visited[i][j] = true;
32                    queue.offerLast(new int[]{i, j, 0}); countLand++;
33                }
34            }
35        }
36
37        if(countLand == 0 || countLand == N * M){
38            return -1;
39        }
40
41        int distance = 0;
42        while(!queue.isEmpty()){
43            int[] element = queue.pollFirst();
44            int x = element[0], y = element[1];
45            distance = element[2];
46
47            addAllNeighbours(grid, visited, x, y, distance + 1, queue);
48        }
49        return distance;
50
51    }
52}