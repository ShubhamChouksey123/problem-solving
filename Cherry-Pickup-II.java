1class Solution {
2
3    private static final int[] DIRECTIONS = new int[]{
4        -1, 0, 1
5    };
6    
7    public int cherryPickup(int[][] grid, int[][][] memo, int n , int m, int row, int col1, int col2) {
8         
9        if(row == n){
10            return 0;
11        }
12
13        if(memo[row][col1][col2] != -1)
14            return memo[row][col1][col2];
15
16        int currentRowCost = grid[row][col1] + grid[row][col2];
17
18        int minNextCost = 0;
19        for(int i = 0 ; i < 3 ; i++){
20            int newRow = row + 1;
21            int newCol1 = col1 + DIRECTIONS[i];
22
23            if(newCol1 < 0 || newCol1 >= m) continue;
24
25            for(int j= 0 ; j < 3 ; j++){
26                int newCol2 = col2 + DIRECTIONS[j];
27
28                if(newCol2 < 0 || newCol2 >= m) continue;
29                if(newCol1 == newCol2) continue;
30
31                int nextCost = cherryPickup(grid, memo, n , m, newRow, newCol1, newCol2); 
32                minNextCost = Math.max(minNextCost, nextCost);
33            }
34        }
35        memo[row][col1][col2] = currentRowCost + minNextCost;
36        return currentRowCost + minNextCost;
37    }
38    
39    public int cherryPickup(int[][] grid) {
40
41        int n = grid.length, m = grid[0].length;
42
43        int[][][] memo = new int[n][m][m];
44
45        for(int[][] matrix : memo){
46            for(int[] row : matrix){
47                Arrays.fill(row, -1);
48            }
49        }
50        return cherryPickup(grid, memo, n, m, 0, 0, m-1);
51
52    }
53}