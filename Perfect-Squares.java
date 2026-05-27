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
13        for(int target = 4 ; target <= n ; target++){
14            for(int i = 2 ; i*i <= target ; i++){
15                dp[target] = Math.min(dp[target], 1 + dp[target - i*i]);
16            }
17        }
18        return dp[n];
19            
20    }
21}