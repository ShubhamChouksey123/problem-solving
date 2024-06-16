class Solution {
    
    private boolean existUtil(char[][] board, int m, int n, String word, int index, int x, int y, boolean[][] visited) {
        
        if(index == word.length()){
            return true;
        }


        if(x < 0 || x >=m || y < 0 || y >= n|| visited[x][y]){
            return false;
        }

        if(board[x][y] != word.charAt(index)){
            return false;
        }
        visited[x][y] = true;

        boolean a = existUtil(board, m, n, word, index +1, x+1,  y,  visited);
        boolean b = existUtil(board, m, n, word, index +1, x,  y+1, visited);
        boolean c = existUtil(board, m, n, word, index +1, x-1,  y, visited);
        boolean d = existUtil(board, m, n, word, index +1, x,  y-1, visited);

        visited[x][y] = false;

        return a | b | c | d;
    }
    
    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(existUtil(board, m, n,  word, 0, i, j, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}