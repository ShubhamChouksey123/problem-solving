1class Solution {
2
3    private static final int[][] DIRECTIONS = new int[][]{
4        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
5    };
6
7    private boolean liesInRange(int n, int m, int x, int y){
8        if(x >= 0 && x < n && y >= 0 && y < m){
9            return true;
10        }
11        return false;
12    }
13
14    private boolean dfs(char[][] board, String word, int index, boolean[][] visited, int x, int y){
15
16        if(board[x][y] != word.charAt(index)){
17            return false;
18        }
19        if(index == word.length() - 1){
20            return true;
21        }
22
23        int n = board.length, m = board[0].length;
24        visited[x][y] = true;
25
26        for(int i = 0 ; i < 4 ; i++){
27            int x1 = x + DIRECTIONS[i][0];
28            int y1 = y + DIRECTIONS[i][1];
29
30            if(liesInRange(n, m, x1, y1) && !visited[x1][y1]){
31                if(dfs(board, word, index + 1, visited, x1, y1)){
32                    return true;
33                }
34            }
35        }
36        visited[x][y] = false;
37        return false;
38    }
39
40    public boolean exist(char[][] board, String word) {
41        int n = board.length;
42        int m = board[0].length;
43        boolean[][] visited = new boolean[n][m];
44
45        for(int i = 0 ; i < n ; i++){
46            for(int j = 0 ; j < m ; j++){
47                if(dfs(board, word, 0, visited, i, j)) return true;
48            }
49        }    
50        return false;
51    }
52}