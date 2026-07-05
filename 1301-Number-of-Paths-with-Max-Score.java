class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {-1, 0}, {0, -1}, {-1, -1}
    };

    private int[] dfs(char[][] board, int n, int[][][] memoCache, int x, int y) {
        
        if(x == 0 && y == 0) {
            return new int[]{0, 1};
        }
        if(memoCache[x][y][1] != -1) return memoCache[x][y];
        

        int maxSum = -1;
        int count = 0;

        int thisValue = 0;
        if(board[x][y] != 'S' && board[x][y] != 'X' && board[x][y] != 'E'){
            thisValue = board[x][y] - '0';
        }
        
        for(int[] direction : DIRECTIONS){
            int x1 = x + direction[0];
            int y1 = y + direction[1];

            if(x1 >= 0 && y1 >= 0 && board[x1][y1] != 'X'){
                int[] innerAns = dfs(board, n, memoCache, x1, y1);

                if(innerAns[0] != -1){

                    int newSum = thisValue + innerAns[0];
                    if(newSum > maxSum){
                        maxSum = newSum; count = innerAns[1];
                    }
                    else if(newSum == maxSum){
                        count = (count + innerAns[1]) % 1_000_000_007;
                    }
                }
            }
        }

        memoCache[x][y][0] = maxSum;
        memoCache[x][y][1] = count;
       return new int[]{maxSum, count};
    }
    
    public int[] pathsWithMaxScore(List<String> board) {
        
        int n = board.size();
        char[][] boardChars = new char[n][n];
        int[][][] memoCache = new int[n][n][2];

        for(int i = 0 ; i < n ; i++){
            char[] row = board.get(i).toCharArray();
            for(int j = 0 ; j < n ; j++){
                boardChars[i][j] = row[j];
                memoCache[i][j][0] = -1;
                memoCache[i][j][1] = -1;
            }
        }
        
        
        int[] ans = dfs(boardChars, n, memoCache, n - 1, n - 1);

        if(ans[0] == -1) return new int[]{0, 0};
        return ans; 
    }
}