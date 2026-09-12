class Solution {
    
    

    public int numSquares(int[] memoCache, int n) {
        if(n <= 3) return n;

        if(memoCache[n] != -1) return memoCache[n];

        int minNums = Integer.MAX_VALUE;
        for(int num = 2 ; num * num <= n ; num++){
            minNums = Math.min(minNums, 1 + numSquares(memoCache, n - (num * num)));
        } 

        memoCache[n] = minNums;
        return minNums;  
    }
    

    public int numSquares(int n) {
        int[] memoCache = new int[n+1];
        Arrays.fill(memoCache, -1);

        return numSquares(memoCache, n);    
    }
    
}