1class Solution {
2    public void setZeroes(int[][] matrix) {
3
4        int n = matrix.length, m = matrix[0].length;
5
6        int[] rowZeros = new int[n];
7        int[] columnZeros = new int[m];
8
9
10        for(int i = 0 ; i < n ; i++){
11            for(int j = 0 ; j < m ; j++){
12                if(matrix[i][j] == 0){
13                    rowZeros[i] = -1;
14                    columnZeros[j] = -1;
15                }
16            }
17        }
18
19        for(int i = 0 ; i < n ; i++){
20            for(int j = 0 ; j < m ; j++){
21                if(rowZeros[i] == -1){
22                    matrix[i][j] = 0;
23                }
24                if(columnZeros[j] == -1){
25                    matrix[i][j] = 0;
26                }
27            }
28        }
29
30
31        
32    }
33}