1class Solution {
2    public int maximalSquare(char[][] matrix) {
3
4        int n = matrix.length, m = matrix[0].length;
5        int[][] dp = new int[n][m];
6
7        // for(int[] row, dp){
8        //     Arrays.fill(row, 0);
9        // }
10    
11        // The max edge of the square
12        int maxValue = 0;
13        for(int i = 0 ; i < n ; i++){
14            for(int j = 0 ; j < m ; j++){
15                if(matrix[i][j] == '0'){
16                    dp[i][j] = 0;
17                    continue; 
18                }
19
20                int left = 0, diagonal = 0, top = 0;
21                if(j - 1 >= 0){
22                    left = dp[i][j-1];
23                }
24                if(i - 1 >= 0 && j - 1 >= 0){
25                    diagonal = dp[i-1][j-1];
26                }
27                if(i - 1 >= 0){
28                    top = dp[i-1][j];
29                }
30
31                int validSquareEdge = Math.min(Math.min(left, diagonal), top) + 1;
32                dp[i][j] = validSquareEdge;
33                maxValue = Math.max(maxValue, validSquareEdge);
34            }
35        }
36        return maxValue * maxValue;
37           
38    }
39
40
41    public record Area (int left, int diagonal, int top) {}
42}