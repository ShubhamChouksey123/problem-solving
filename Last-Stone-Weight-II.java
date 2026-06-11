1class Solution {
2    public int lastStoneWeightII(int[] stones) {
3
4        int n = stones.length; 
5        int totalSum = 0;
6        for(int stone : stones){
7            totalSum += stone;
8        }
9
10        int target = totalSum / 2 ;
11        boolean[][] dp = new boolean[n+1][target + 1];
12
13
14        for(int element = 0 ; element <= n ; element++){
15            dp[element][0] = true;
16        }
17
18        int maxPossibleSum = 0;
19        for(int element = 1 ; element <= n ; element++){
20
21            int index = element - 1;
22            for(int sum = 1 ; sum <= target ; sum ++){
23                dp[element][sum] = dp[element-1][sum];
24
25                if(sum >= stones[index]){
26                    dp[element][sum] = dp[element][sum] || dp[element-1][sum - stones[index]];
27                } 
28                if(dp[element][sum] && maxPossibleSum < sum) maxPossibleSum = sum;
29            }
30        }
31
32        return totalSum - (2 * maxPossibleSum);
33        
34    }
35}