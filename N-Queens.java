1class Solution {
2    
3    private void addBoardToResult(int n, boolean[][] board, List<List<String>> ans){
4
5        List<String> result = new ArrayList<>();
6        for(int i = 0 ; i < n ; i++){
7            StringBuilder builder = new StringBuilder();
8            for(int j = 0 ; j < n ; j++){
9                if(board[i][j]) {
10                    builder.append('Q');
11                }else{
12                    builder.append('.');
13                }
14            }
15            result.add(builder.toString());
16        }
17        ans.add(result);
18    }
19
20    private boolean isValid(int n, boolean[][] board, int row, int column){
21        
22
23        // same column check
24        for(int i = 0 ; i < n ; i++){
25            if(i == row) continue;
26            if(board[i][column]) return false;
27        }
28
29        // same row check
30        for(int j = 0 ; j < n ; j++){
31            if(j == column) continue;
32            if(board[row][j]) return false;
33        }
34
35        for(int i = 0 ; i < n ; i++){
36            for(int j = 0 ; j < n ; j++){
37                if(i == row && j == column) continue;
38
39                if(i + j == row + column && board[i][j]) return false;
40
41                if(i - j == row - column && board[i][j]) return false;
42            }
43        }
44
45        return true;
46    }
47
48    private void solveNQueens(int n, boolean[][] board, List<List<String>> ans, int row) {
49
50        if(row == n){
51            addBoardToResult(n, board, ans); return;
52        }
53
54        for(int column = 0 ; column < n ; column++){
55            if(!isValid(n, board, row, column)) continue;
56                
57            
58            board[row][column] = true;
59                solveNQueens(n, board, ans, row + 1);
60
61                board[row][column] = false;
62        }
63    }
64    
65    public List<List<String>> solveNQueens(int n) {
66        boolean[][] board = new boolean[n][n];
67        List<List<String>> ans = new ArrayList<>();
68        solveNQueens(n, board, ans, 0); 
69        
70        return ans;
71    }
72}