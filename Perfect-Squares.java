1class Solution {
2    
3    public int numSquares(int n) {
4
5        if(n <= 3) return n;    
6        int[] dp = new int[n+1];
7        Arrays.fill(dp, Integer.MAX_VALUE);
8        for(int i = 0 ; i <= 3 ; i++){
9            dp[i] = i;
10        }
11
12
13
14        for(int i = 2 ; i * i <= n ; i++){
15            for(int j = 4 ; j <= n ; j++){
16                if(j >= i * i){
17                    dp[j] = Math.min(dp[j], 1 + dp[j - i*i]);
18                }
19            }
20        }
21        return dp[n];
22            
23    }
24}