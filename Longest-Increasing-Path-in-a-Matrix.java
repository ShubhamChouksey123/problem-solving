1class Solution {
2
3    private static final int[][] DIRECTIONS = new int[][]{
4        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
5    };
6    
7    private int dfs(int[][] matrix, int[][] memo, int n, int m, int start, int end){
8
9        if(memo[start][end] != 0)
10            return memo[start][end];
11
12        int maxNeighbourStep = 0;
13
14        for(int[] direction : DIRECTIONS){
15            int x = start + direction[0];
16            int y = end   + direction[1];
17            if(x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] > matrix[start][end]){
18                int neighbourStep = dfs(matrix, memo, n, m, x, y);
19                maxNeighbourStep = Math.max(neighbourStep, maxNeighbourStep);
20            }
21        }
22        memo[start][end] = 1 + maxNeighbourStep;
23        return memo[start][end];
24    }
25    
26    public int longestIncreasingPath(int[][] matrix) {
27
28        int n = matrix.length;
29        int m = matrix[0].length;
30        int maxStep = 1;
31
32        int[][] memo = new int[n][m];
33
34        for(int i = 0 ; i < n ; i ++){
35            for(int j = 0 ; j < m ; j++){
36                int step = dfs(matrix, memo, n, m, i, j);
37                maxStep = Math.max(step, maxStep);
38            }
39        }
40        return maxStep;
41    }
42}