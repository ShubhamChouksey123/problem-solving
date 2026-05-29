1class Solution {
2    public int minFallingPathSum(int[][] matrix) {
3
4        int n = matrix.length;
5        int[] prev = new int[n];
6        int[] curr = new int[n];
7
8        for(int column = 0; column < n ; column++){
9            prev[column] = matrix[0][column];
10        }
11
12        for(int row = 1 ; row < n ; row++){
13            curr = new int[n];
14            for(int column = 0; column < n ; column++){
15                
16                curr[column] = matrix[row][column];
17                int minValue = prev[column];
18                if(column-1 >= 0){
19                    minValue = Math.min(minValue, prev[column - 1]); 
20                }
21                if(column+1 < n){
22                    minValue = Math.min(minValue, prev[column + 1]); 
23                }
24                curr[column] += minValue;
25            
26            }
27            prev = curr;
28            
29        }
30
31        int minValue = prev[0];
32        for(int row = 1 ; row < n ; row++){
33            minValue = Math.min(minValue , prev[row]);
34        }
35
36        return minValue;
37    }
38}