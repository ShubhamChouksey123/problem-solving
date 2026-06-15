1class Solution {
2    public int maximalSquare(char[][] matrix) {
3        
4        int n = matrix.length, m = matrix[0].length;
5        int[][] dp = new int[n][m];
6        int maxValue = 0;
7
8        for(int row = 0 ; row < n ; row++){
9            for(int column = 0 ; column < m ; column++){
10                if(matrix[row][column] == '0') continue;
11                int minValue = Integer.MAX_VALUE;
12                int a = 0, b = 0, c = 0;
13                if(row - 1 >= 0){
14                    a = dp[row-1][column];
15                }
16                if(column - 1 >= 0){
17                    b = dp[row][column-1];
18                }
19                if(row - 1 >= 0 && column - 1 >= 0){
20                    c = dp[row-1][column-1];
21                }
22                minValue = Math.min(a, Math.min(b, c));    
23                dp[row][column] = minValue + 1;
24                maxValue = Math.max(maxValue, dp[row][column]);
25            }
26        }
27
28        return maxValue * maxValue;
29    }
30}