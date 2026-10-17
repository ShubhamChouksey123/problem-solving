class Solution {
    
    public int fib(int n, int[] memoCache) {
        
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(memoCache[n] != -1) return memoCache[n];

        return memoCache[n] = (fib(n - 1) + fib(n - 2));
    }
    
    public int fib(int n) {
        
        int[] memoCache = new int[n + 1];
        Arrays.fill(memoCache, -1);

        return fib(n, memoCache);
    }
}