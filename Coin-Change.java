1class Solution {
2    
3    private long[] memo;
4
5    private long minCoins(int[] coins, int amount){
6
7        if(amount == 0)
8            return 0;
9
10        if(amount < 0)
11            return 0;
12
13        if(memo[amount] != -1){
14            return memo[amount];
15        }
16        
17        long minCoin = Integer.MAX_VALUE;
18        for(int coin : coins){
19            if(coin <= amount){
20                minCoin = Math.min(1 + minCoins(coins, amount - coin), minCoin);
21            }
22        }
23        memo[amount] = minCoin;
24        return minCoin;
25
26    }
27    
28    public int coinChange(int[] coins, int amount) {
29
30        memo = new long[amount + 1];
31        Arrays.fill(memo, -1);
32        memo[0] = 0;
33
34        long minCoin = minCoins(coins, amount);
35
36        if(minCoin == Integer.MAX_VALUE)
37            return -1;
38        return (int)minCoin; 
39    }
40}