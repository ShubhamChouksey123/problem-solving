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
12            // Base case
13            if(row1 == row2 && col1 == col2){
14                return grid[row1][col1];
15            }    
16            return grid[row1][col1] + grid[row2][col2];  
17        }
18
19        if(memo[row1][col1][col2] != -1){
20            return memo[row1][col1][col2];
21        }
22
23        int currentCherryPick = 0;
24        // Same cell
25        if(row1 == row2 && col1 == col2){
26            currentCherryPick = grid[row1][col1];
27        }
28        else{
29            // differet cells
30            currentCherryPick = grid[row1][col1] + grid[row2][col2];
31        }
32
33        
34        int maxNextCherryPick = Integer.MIN_VALUE;
35        for(int i = 0 ; i < 2 ; i++){
36            int newRow1 = row1 + DIRECTION_RIGHT_DOWN[i][0];
37            int newCol1 = col1 + DIRECTION_RIGHT_DOWN[i][1];
38 
39            if(newRow1 < 0 || newRow1 >= n || newCol1 < 0 || newCol1 >= n) continue;
40            if(grid[newRow1][newCol1] == -1) continue;
41
42            for(int j = 0 ; j < 2 ; j++){
43
44                int newRow2 = row2 + DIRECTION_RIGHT_DOWN[j][0];
45                int newCol2 = col2 + DIRECTION_RIGHT_DOWN[j][1];
46
47                
48                if(newRow2 < 0 || newRow2 >= n || newCol2 < 0 || newCol2 >= n) continue;
49                if(grid[newRow2][newCol2] == -1) continue;
50
51                int nextCherryPick = cherryPickup(grid, memo, n, newRow1 , newCol1 , newCol2);
52                maxNextCherryPick = Math.max(maxNextCherryPick, nextCherryPick);
53            }
54        }
55
56        if(maxNextCherryPick == Integer.MIN_VALUE){
57            memo[row1][col1][col2] =Integer.MIN_VALUE;
58            return Integer.MIN_VALUE;
59        }
60
61        memo[row1][col1][col2] = currentCherryPick + maxNextCherryPick;
62        return currentCherryPick + maxNextCherryPick;
63    }
64    
65    public int cherryPickup(int[][] grid) {
66        int n = grid.length;
67        int[][][] memo = new int[n][n][n];
68
69        for(int[][] matrix : memo){
70            for(int[] row : matrix){
71                Arrays.fill(row, -1);
72            }
73        }
74
75        int ans = cherryPickup(grid, memo, n, 0, 0 , 0); 
76        return ans == Integer.MIN_VALUE ? 0 : ans;
77    }
78}