1class Solution {
2
3    private static final int[][] DIRECTIONS = new int[][]{
4        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
5    };
6
7    public int minimumEffortPath(int[][] heights) {
8
9        int n = heights.length, m = heights[0].length;
10
11        int[][] minEfforts = new int[n][m];
12        for(int i = 0 ; i < n ; i++){
13            Arrays.fill(minEfforts[i], Integer.MAX_VALUE);
14        }
15
16        minEfforts[0][0] = 0;
17
18        // Queue containing node and its effort
19        // {x, y, effort}
20        Queue<int[]> pq = new PriorityQueue<>(
21            (a, b) -> Integer.compare(a[2], b[2])
22        );
23        pq.add(new int[]{0, 0, 0});
24
25        while(!pq.isEmpty()){
26
27            int[] curr = pq.poll();
28            int nodeX = curr[0], nodeY = curr[1], effort = curr[2];
29
30            if(effort > minEfforts[nodeX][nodeY]) continue;
31
32            if(nodeX == n - 1 && nodeY == m - 1) break;
33
34            for(int[] direction : DIRECTIONS) {
35                int x = nodeX + direction[0]; 
36                int y = nodeY + direction[1];
37
38                if(x < 0 || x >= n || y < 0 || y >= m) continue;
39
40                int newEffort = Math.max(effort , Math.abs(heights[x][y] - heights[nodeX][nodeY] ));
41
42                if(newEffort < minEfforts[x][y]){
43                    minEfforts[x][y] = newEffort; 
44                    pq.add(new int[]{x, y, newEffort});
45                }
46            }
47        }
48        return minEfforts[n-1][m-1];
49    }
50}