class Solution {
    
    
    private int fibUtil(int n, int[] dp){
        
        if(n == 0)
            return 0;
        
        if(n <= 1)
            return 1;
        
        if(dp[n] != 0)
            return dp[n];
        
        return fibUtil(n-1, dp) + fibUtil(n-2, dp);
        
    }
    
    public int fib(int n) {
        
        int[] dp = new int[n+1];
        
        return fibUtil(n, dp);
    }
}