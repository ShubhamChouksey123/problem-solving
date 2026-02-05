1class Solution {
2
3    public void rotate(int[][] matrix) {
4
5        int n = matrix.length, m = matrix[0].length;
6
7        for(int i = 0 ; i < n ; i++){
8            for(int j = 0 ; j < i ; j++){
9                int tmp = matrix[i][j];
10                matrix[i][j] = matrix[j][i];
11                matrix[j][i] = tmp; 
12            }
13        }
14        
15        for(int i = 0 ; i < n ; i++){
16            for(int j = 0 ; j < m/2 ; j++){
17                int tmp = matrix[i][j];
18                matrix[i][j] = matrix[i][m-j-1];
19                matrix[i][m-j-1] = tmp; 
20            }
21        }
22    }
23}