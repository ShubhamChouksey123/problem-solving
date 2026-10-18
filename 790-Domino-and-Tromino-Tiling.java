class Solution {

    private final int MOD = 1_000_000_000 + 7;
    
    public long numTilings(int n, long[] memoCache) {
        if(n <= 2) return n;
        if(n == 3) return 5;
        if(n <= 0) return 0;
        if(memoCache[n] != -1) return memoCache[n];

        long a = (2 * numTilings(n - 1, memoCache)) % MOD;
        long b = numTilings(n - 3, memoCache) % MOD;
        long ans = (a + b) % MOD;
        return memoCache[n] = ans;
    }
    
    public int numTilings(int n) {

        long[] memoCache = new long[n + 1];
        Arrays.fill(memoCache, -1);

        long ans = numTilings(n, memoCache);   
        return (int) ans;
    }
}