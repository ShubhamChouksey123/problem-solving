1class Solution {
2
3    private boolean isSafeToAdd(int n, boolean[][] board, int x, int y){
4        if(board[x][y]){
5            return false;
6        }
7        int i = 0, j = 0;
8        for(i = 0 ; i < n ; i++){
9            if(board[i][y]) return false;    
10        }
11        for(j = 0 ; j < n ; j++){
12            if(board[x][j]) return false;
13        }
14        
15        // anti diagonal 
16        int sum = x + y; j = 0;
17        for(i = sum ; i >= 0 ; i--){
18            j = sum - i;
19            if( i < n && j >= 0 && j < n){
20                if(board[i][j]) return false;
21            }
22            
23        }
24
25        // main diagonal 
26        i = 0 ; int diff = x - y;
27        for(i = 0 ; i < n ; i++){
28            j = i - diff;
29            if(j >= 0 && j < n){
30                if(board[i][j]) return false;
31            }
32        }
33        return true;
34    }
35
36    private List<String> convertBoardToString(int n, boolean[][] board){
37        List<String> result = new ArrayList<>(); 
38        for(int i = 0 ; i < n ; i++){
39            StringBuilder stringBuilder  = new StringBuilder();
40            for(int j = 0 ; j < n ; j++){
41                stringBuilder.append(board[i][j] ? 'Q' : '.') ;
42                
43            }
44            result.add(stringBuilder.toString());
45        }
46        return result;
47    }
48
49
50    public void solveNQueensutil(List<List<String>> ans, int n, boolean[][] board, int row) {
51        
52        if(row == n){
53            List<String> result = convertBoardToString(n, board);
54            ans.add(result);
55            return;
56        }
57
58        for(int j = 0 ; j < n ; j++){
59            if(isSafeToAdd(n, board, row, j)){
60                board[row][j] = true;
61                solveNQueensutil(ans, n, board, row + 1);
62                board[row][j] = false;
63            }
64        }
65        
66        
67    }
68
69    public List<List<String>> solveNQueens(int n) {
70        List<List<String>> ans = new ArrayList<>();
71        solveNQueensutil(ans, n, new boolean[n][n], 0); 
72
73        return ans; 
74    }
75}