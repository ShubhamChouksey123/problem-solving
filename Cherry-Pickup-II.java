1class Solution {
2
3
4    private static final int[] DIRECTIONS = new int[]{
5        -1, 0, 1
6    };
7
8    private int cherryPickupUtil(int[][] grid, int n, int m, int[][][] dp, int row, int col1, int col2) {
9
10        if(row == n - 1){
11            return grid[row][col1] + grid[row][col2];
12        }
13
14        if(dp[row][col1][col2] != -1)
15            return dp[row][col1][col2];
16
17        int currentCherries = grid[row][col1] + grid[row][col2];
18        int maxNextLevelPick = 0;
19
20        for(int i = 0 ; i < 3 ; i++){
21            int nextCol1 = col1 + DIRECTIONS[i];
22
23            if(nextCol1 < 0 || nextCol1 >= m) continue;
24                
25            for(int j = 0 ; j < 3 ; j++){
26                int nextCol2 = col2 + DIRECTIONS[j];
27
28                if(nextCol2 < 0 || nextCol2 >= m) continue;
29                if(nextCol1 == nextCol2) continue;
30
31                int nextLevelPick = cherryPickupUtil(grid, n, m, dp, row + 1, nextCol1, nextCol2);
32                maxNextLevelPick = Math.max(maxNextLevelPick, nextLevelPick);
33            }
34        }
35        dp[row][col1][col2] = currentCherries + maxNextLevelPick;
36        return currentCherries + maxNextLevelPick;
37    }
38
39    public int cherryPickup(int[][] grid) {
40        int n = grid.length, m = grid[0].length;
41
42        int[][][] dp = new int[n][m][m];
43        for(int[][] in: dp){
44            for(int[] row : in){
45                Arrays.fill(row, -1);
46            }   
47        }
48
49        return cherryPickupUtil(grid, n, m, dp, 0, 0, m - 1);
50    }
51}