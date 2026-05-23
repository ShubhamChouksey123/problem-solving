1class Solution {
2
3    public int lastStoneWeightII(int[] stones) {
4
5        int n = stones.length;
6        int totalValue = 0;
7
8        for(int stone : stones){
9            totalValue += stone;
10        }
11        int target = totalValue / 2;
12        int[] dp = new int[target + 1];
13        
14
15        for(int element = 1 ; element <= n ; element++){
16            for(int sum = target ; sum >= 0 ; sum--){
17                int index = element - 1;
18
19                if(sum >= stones[index]){
20                    dp[sum] = Math.max(dp[sum] , stones[index] + dp[sum - stones[index]] );
21                }  
22            }
23        }
24            
25        int s1 = dp[target];
26        return totalValue - 2 * s1;
27    }
28}