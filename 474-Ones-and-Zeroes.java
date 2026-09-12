class Solution {

    private int countZeros(String s){
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '0') count++;
        }
        return count;
    }
    
    public int findMaxForm(String[] strs, int[][][] memoCache, int m, int n, int index) {
        
        if(m < 0 || n < 0) return 0;
        if(index >= strs.length) return 0;
        if(memoCache[index][m][n] != -1) return memoCache[index][m][n];

        int zeros = countZeros(strs[index]);
        int ones = strs[index].length() - zeros;

        int take = 0;
        if(m >= zeros && n >= ones){
            take = 1 + findMaxForm(strs, memoCache, m - zeros, n - ones, index + 1) ;
        }
        
        int notTake = 0 + findMaxForm(strs, memoCache, m, n, index + 1) ;


        int optimalValue = Math.max(take, notTake);
        memoCache[index][m][n] = optimalValue;
        return optimalValue;
    }
    
    public int findMaxForm(String[] strs, int m, int n) {
        

        int length = strs.length;
        int[][][] memoCache = new int[length][m + 1][n + 1];
        for(int[][] matrix : memoCache){
            for(int[] row : matrix)
                Arrays.fill(row, -1);
        }

        return findMaxForm(strs, memoCache, m, n, 0); 

    }
}