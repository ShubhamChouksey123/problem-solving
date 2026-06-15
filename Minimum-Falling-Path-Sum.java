1class Solution {
2    public int minFallingPathSum(int[][] matrix) {
3
4        int n = matrix.length;
5        List<Integer> prev = new ArrayList<>();
6        List<Integer> curr = new ArrayList<>();
7        
8        for(int i = 0 ; i < n ; i++){
9            prev.add(matrix[0][i]);
10        }
11
12        for(int row = 1 ; row < n ; row++){
13            curr = new ArrayList<>();
14            for(int column = 0 ; column < n ; column++){
15                int minAboveSum = prev.get(column);
16                if(column - 1 >= 0){
17                    minAboveSum = Math.min(minAboveSum, prev.get(column - 1));
18                }
19                if(column + 1 < n){
20                    minAboveSum = Math.min(minAboveSum, prev.get(column + 1));
21                }
22                curr.add(minAboveSum + matrix[row][column]);
23            } 
24            prev = curr;
25        }
26        int minPathSum = Integer.MAX_VALUE;
27        for(int column = 0 ; column < n ; column++){
28            minPathSum = Math.min(minPathSum, prev.get(column));
29        }
30
31        return minPathSum;
32    }   
33}