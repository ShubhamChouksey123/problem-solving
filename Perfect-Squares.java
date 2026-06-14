1class Solution {
2    
3    private int numSquares(int[] dp, int n) {
4
5        if(n <= 3) return n;
6        if(dp[n] != -1) return dp[n];
7
8        int minNumbers = n;
9        for(int i = 2 ; i * i <= n ; i++){
10            minNumbers = Math.min(1 + numSquares(dp, n - (i*i)), minNumbers);
11        }
12
13        dp[n] = minNumbers;
14        return minNumbers;
15    }
16    
17    public int numSquares(int n) {
18
19        int[] dp = new int[n+1];
20        Arrays.fill(dp, -1);
21        return numSquares(dp, n);
22    }
23}