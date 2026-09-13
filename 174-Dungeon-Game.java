class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

        int n = dungeon.length, m = dungeon[0].length;

        // required minimum health at that index (x, y)
        int[][] minHealth = new int[n][m];


        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = m - 1 ; j >= 0 ; j--){
                if(i == n - 1 && j == m - 1){
                    minHealth[i][j] = -1 * Math.min(dungeon[i][j], 0);   continue; 
                }
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                if( j + 1 < m){
                    a = -1 * Math.min(dungeon[i][j] - minHealth[i][j+1], 0);
                }
                if( i + 1 < n){
                    b = -1 * Math.min(dungeon[i][j] - minHealth[i+1][j], 0);
                }
                minHealth[i][j] = Math.min(a, b); 

            }
        }
        return minHealth[0][0] + 1;
    }
}