class Solution {
    
    private double soupServings(double[][] memoCache, int a, int b) {

        if(a <= 0 && b <= 0) return 0.5;
        if(a <= 0 && b > 0) return 1.0;
        if(a > 0 && b <= 0) return 0.0;
        
        
        if(memoCache[a][b] != -1.0) return memoCache[a][b];
    
        double case1 = 0.25 *  soupServings(memoCache, a - 4, b);
        double case2 = 0.25 *  soupServings(memoCache, a - 3, b - 1);
        double case3 = 0.25 *  soupServings(memoCache, a - 2, b - 2);
        double case4 = 0.25 *  soupServings(memoCache, a - 1, b - 3);
        return memoCache[a][b] = case1 + case2 + case3 + case4;
    }
    
    public double soupServings(int n) {

        if(n >= 4800) return 1.0;
        
        int N = (int) Math.ceil(n / 25.0);
        double[][] memoCache = new double[N+1][N+1];
        for(double[] row : memoCache){
            Arrays.fill(row, -1.0);
        }
        return soupServings(memoCache, N, N);
    }
}