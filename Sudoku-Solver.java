1class Solution {
2    
3    private static final int N = 9; 
4    private static final int N_3 = 3; 
5
6    private boolean isValid(char[][] board, int x, int y, char value){
7        if(board[x][y] != '.'){
8            return false;
9        }
10        for(int i = 0 ; i < N ; i++){
11            if(board[i][y] == value) return false;
12        }
13        for(int j = 0 ; j < N ; j++){
14            if(board[x][j] == value) return false;
15        }
16
17        int startX = (x / 3) * 3; 
18        int startY = (y / 3) * 3;
19        for(int i = 0; i < N_3 ; i++){
20            for(int j = 0; j < N_3 ; j++){
21                if(board[startX + i][startY + j] == value) return false;        
22            } 
23        }
24        return true;    
25    }
26    
27    public boolean solveSudokuUtil(char[][] board, int row, int col) {
28        if(col == N){
29            return solveSudokuUtil(board, row + 1, 0);
30        }
31        if(row == N){
32            return true;
33        }
34        if(board[row][col] != '.'){
35            return solveSudokuUtil(board, row, col + 1);
36        }
37        
38
39        for(char val = '1' ; val <= '9' ; val++){
40            if(isValid(board, row, col, val)){
41                board[row][col] = val;
42                if(solveSudokuUtil(board, row, col + 1)){
43                    return true;
44                }
45                board[row][col] = '.';
46            }
47        } 
48        
49        return false;
50    }
51    
52    public void solveSudoku(char[][] board) {
53        solveSudokuUtil(board, 0, 0); 
54    }
55}