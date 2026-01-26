1class NumMatrix {
2
3    int n, m;
4    long[][] sumMatrix ;
5
6    public NumMatrix(int[][] matrix) {
7        n = matrix.length;
8        m = matrix[0].length;
9        sumMatrix = new long[n][m];
10
11        for(int i = 0 ; i < n ; i++){
12            long rowSum = 0; 
13            for(int j = 0 ; j < m ; j++){
14                rowSum += matrix[i][j];
15                if(i == 0){
16                    sumMatrix[i][j] = rowSum;
17                }else{
18                    sumMatrix[i][j] = sumMatrix[i-1][j] + rowSum;
19                }
20            }
21        }
22    }
23    
24    public int sumRegion(int row1, int col1, int row2, int col2) {
25
26        long ans = sumMatrix[row2][col2];
27
28        if(row1-1 >= 0) {
29            ans -= sumMatrix[row1-1][col2];
30        }
31        if(col1-1 >= 0) {
32            ans -= sumMatrix[row2][col1-1];
33        }
34        if(row1-1 >= 0 && col1-1 >= 0){
35            ans += sumMatrix[row1-1][col1-1];
36        }
37
38        return (int)ans;
39    }
40}
41
42/**
43 * Your NumMatrix object will be instantiated and called as such:
44 * NumMatrix obj = new NumMatrix(matrix);
45 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
46 */