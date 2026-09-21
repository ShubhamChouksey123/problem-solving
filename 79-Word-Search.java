class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    private boolean exist(char[][] board, int n, int m, String word, boolean[][] visited, int index, int a, int b) {
        
        if(index == word.length()) return false;
        if(word.charAt(index) != board[a][b]) return false;

        if(index == word.length() - 1) return true;

        visited[a][b] = true;

        for(int[] direction : DIRECTIONS){
            int x = a + direction[0];
            int y = b + direction[1];

            if(x < 0 || x >= n || y < 0 || y >= m || visited[x][y]) continue;

            if(exist(board, n, m, word, visited, index + 1, x, y)){
                return true;
            } 
        }
        visited[a][b] = false;
        return false;       
    }

    public boolean exist(char[][] board, String word) {

        int n = board.length, m = board[0].length;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                boolean[][] visited = new boolean[n][m];
                if(exist(board, n, m, word, visited, 0, i, j)) return true;
            }
        }
        return false;
    }
}