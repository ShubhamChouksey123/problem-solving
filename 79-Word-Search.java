class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    private boolean exist(char[][] board, String word, boolean[][] visited, int n, int m, int index, int x, int y) {

        if(index == word.length()) return true;

        if(word.charAt(index) != board[x][y]) return false; 
        if(index == word.length() - 1) return true; 
        
        visited[x][y] = true;
        
        for(int[] direction : DIRECTIONS){
            int x1 = x + direction[0];
            int y1 = y + direction[1];

            if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;
            if(visited[x1][y1]) continue;

            if(exist(board, word, visited, n, m, index + 1, x1, y1)) return true;
        }
        visited[x][y] = false;
        return false;
    }


    public boolean exist(char[][] board, String word) {

        int n = board.length, m = board[0].length;
    
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                boolean[][] visited = new boolean[n][m];
                if(exist(board, word, visited, n, m, 0, i, j)) return true;
            }
        }
        return false;
        
    }
}