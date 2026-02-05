1class Solution {
2
3    private final int[][] diff = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
4
5    private boolean liesInRange(int n, int m, int x, int y){
6        if(x >= 0 && x < n && y >= 0 && y < m){
7            return true;
8        }
9        return false;
10    }
11
12    private int getNeighboursCount(int[][] board, int x, int y){
13        int count = 0;
14        int n = board.length, m = board[0].length;
15        for(int i = 0 ; i < 8 ; i++){
16            int x1 = x + diff[i][0];
17            int y1 = y + diff[i][1];
18            if(liesInRange(n, m, x1, y1)){
19                if(board[x1][y1] == 1 || board[x1][y1] == -1){
20                    count++;
21                }
22            }
23        }
24        return count;
25    }
26
27    public void gameOfLife(int[][] board) {
28
29        int n = board.length, m = board[0].length;
30        
31        for(int i = 0 ; i < n ; i++){
32            for(int j = 0 ; j < m ; j++){
33                int liveNeighboursCount = getNeighboursCount(board, i, j);
34                if(board[i][j] == 1){
35                    if(liveNeighboursCount < 2){
36                        board[i][j] = -1;
37                    }else if(liveNeighboursCount > 3){
38                        board[i][j] = -1;
39                    }
40                }else if(board[i][j] == 0){
41                    if(liveNeighboursCount == 3){
42                        board[i][j] = 2;
43                    }
44                }
45                
46            }
47        }
48
49        for(int i = 0 ; i < n ; i++){
50            for(int j = 0 ; j < m ; j++){
51                if(board[i][j] == -1){
52                    board[i][j] = 0;
53                }else if(board[i][j] == 2){
54                    board[i][j] = 1;
55                }    
56            }
57        }
58        
59    }
60}