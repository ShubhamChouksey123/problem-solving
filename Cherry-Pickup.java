1class Solution {
2    
3    private static final int[][] DIRECTION_RIGHT_DOWN = new int[][]{
4        {0, 1}, {1, 0}
5    };
6
7    private int cherryPickup(int[][] grid, int[][][] memo, int n, int row1 , int col1 , int col2) {
8        
9        int row2 = row1 + col1 - col2;
10
11        if(row1 == n - 1 && col1 == n - 1){
12            return grid[row1][col1];
13        }
14
15        if(memo[row1][col1][col2] != -1){
16            return memo[row1][col1][col2];
17        }
18
19        int currentCherryPick = 0;
20        // Same cell
21        if(row1 == row2 && col1 == col2){
22            currentCherryPick = grid[row1][col1];
23        }
24        else{
25            // differet cells
26            currentCherryPick = grid[row1][col1] + grid[row2][col2];
27        }
28
29        
30        int maxNextCherryPick = Integer.MIN_VALUE;
31        for(int i = 0 ; i < 2 ; i++){
32            int newRow1 = row1 + DIRECTION_RIGHT_DOWN[i][0];
33            int newCol1 = col1 + DIRECTION_RIGHT_DOWN[i][1];
34 
35            if(newRow1 < 0 || newRow1 >= n || newCol1 < 0 || newCol1 >= n) continue;
36            if(grid[newRow1][newCol1] == -1) continue;
37
38            for(int j = 0 ; j < 2 ; j++){
39
40                int newRow2 = row2 + DIRECTION_RIGHT_DOWN[j][0];
41                int newCol2 = col2 + DIRECTION_RIGHT_DOWN[j][1];
42
43                
44                if(newRow2 < 0 || newRow2 >= n || newCol2 < 0 || newCol2 >= n) continue;
45                if(grid[newRow2][newCol2] == -1) continue;
46
47                int nextCherryPick = cherryPickup(grid, memo, n, newRow1 , newCol1 , newCol2);
48                maxNextCherryPick = Math.max(maxNextCherryPick, nextCherryPick);
49            }
50        }
51
52        if(maxNextCherryPick == Integer.MIN_VALUE){
53            memo[row1][col1][col2] =Integer.MIN_VALUE;
54            return Integer.MIN_VALUE;
55        }
56
57        memo[row1][col1][col2] = currentCherryPick + maxNextCherryPick;
58        return currentCherryPick + maxNextCherryPick;
59    }
60    
61    public int cherryPickup(int[][] grid) {
62        int n = grid.length;
63        int[][][] memo = new int[n][n][n];
64
65        for(int[][] matrix : memo){
66            for(int[] row : matrix){
67                Arrays.fill(row, -1);
68            }
69        }
70
71        int ans = cherryPickup(grid, memo, n, 0, 0 , 0); 
72        return ans == Integer.MIN_VALUE ? 0 : ans;
73    }
74}