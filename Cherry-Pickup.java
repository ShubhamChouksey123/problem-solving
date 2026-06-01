1class Solution {
2    
3    private static final int[][] RIGHT_DOWN = new int[][]{
4        {1, 0}, {0, 1}
5    };
6
7
8    private int cherryPickup(int[][] grid, int n, int m, int[][][] dp, int row1, int col1, int col2) {
9
10        int row2 = row1 + col1 - col2;
11
12        // Both reached the bottom right corner
13        if(row1 == n - 1 && col1 == m - 1){
14            return grid[n-1][m-1];
15        }
16
17        if(dp[row1][col1][col2] != -2)
18            return dp[row1][col1][col2];
19
20        int thisLevelSum = 0;
21        if(row1 == row2 && col1 == col2){
22            thisLevelSum += grid[row1][col1];
23        }
24        else {
25            thisLevelSum += grid[row1][col1];
26            thisLevelSum += grid[row2][col2];
27        }
28
29        int maxInnerSum = Integer.MIN_VALUE;
30        for(int i = 0 ; i < 2 ; i++){
31            int newRow1 = row1 + RIGHT_DOWN[i][0];
32            int newCol1 = col1 + RIGHT_DOWN[i][1];
33
34            if(newRow1 < 0 || newRow1 >= n || newCol1 < 0 || newCol1 >= m) continue;
35            if(grid[newRow1][newCol1] == -1) continue;
36
37            for(int j = 0 ; j < 2 ; j++){
38                int newRow2 = row2 + RIGHT_DOWN[j][0];
39                int newCol2 = col2 + RIGHT_DOWN[j][1];
40
41                if(newRow2 < 0 || newRow2 >= n || newCol2 < 0 || newCol2 >= m) continue;
42                if(grid[newRow2][newCol2] == -1) continue;
43
44                int innerSum = cherryPickup(grid, n, m, dp, newRow1, newCol1, newCol2);
45                maxInnerSum = Math.max(maxInnerSum, innerSum);
46            }
47        }
48
49        // Bloked Path
50        if(maxInnerSum == Integer.MIN_VALUE){
51            dp[row1][col1][col2] = Integer.MIN_VALUE;
52            return Integer.MIN_VALUE;
53        }
54        dp[row1][col1][col2] = thisLevelSum + maxInnerSum;
55        return dp[row1][col1][col2];
56    }
57
58    public int cherryPickup(int[][] grid) {
59
60        int n = grid.length, m = grid[0].length;
61        int[][][] dp = new int[n][m][m];
62        for(int[][] in : dp){
63            for(int[] row : in){
64                Arrays.fill(row, -2);
65            }
66        }
67
68        int maxSum = cherryPickup(grid, n, m, dp, 0 , 0, 0);
69
70        return (maxSum == Integer.MIN_VALUE) ? 0 : maxSum;
71    }
72}