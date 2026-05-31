1class Solution {
2    public int maximalSquare(char[][] matrix) {
3
4        int n = matrix.length, m = matrix[0].length;
5        int[][] dp = new int[n][m];
6        
7        // The max edge of the square
8        int maxValue = 0;
9        for(int i = 0 ; i < n ; i++){
10            for(int j = 0 ; j < m ; j++){
11                if(matrix[i][j] == '0'){
12                    dp[i][j] = 0;
13                    continue; 
14                }
15
16                int left = 0, diagonal = 0, top = 0;
17                if(j - 1 >= 0){
18                    left = dp[i][j-1];
19                }
20                if(i - 1 >= 0 && j - 1 >= 0){
21                    diagonal = dp[i-1][j-1];
22                }
23                if(i - 1 >= 0){
24                    top = dp[i-1][j];
25                }
26
27                int validSquareEdge = Math.min(Math.min(left, diagonal), top) + 1;
28                dp[i][j] = validSquareEdge;
29                maxValue = Math.max(maxValue, validSquareEdge);
30            }
31        }
32        return maxValue * maxValue;
33           
34    }
35
36
37    public record Area (int left, int diagonal, int top) {}
38}