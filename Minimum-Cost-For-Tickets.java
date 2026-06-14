1class Solution {
2    
3    public int mincostTickets(int[] days, int[] costs) {
4        
5        int n = days.length;
6        int[] dp = new int[366];
7
8        int indexOnDay = n - 1;
9        for(int i = 365 ; i >= 1 ; i--){
10            if(indexOnDay >= 0 && days[indexOnDay] == i){
11                // we might need to purchase ticket
12                int a = costs[0];
13                if(i + 1 <= 365){
14                    a += dp[i+1];
15                }
16                int b = costs[1];
17                if(i + 7 <= 365){
18                    b += dp[i+7];
19                }
20                int c = costs[2];
21                if(i + 30 <= 365){
22                    c += dp[i+30];
23                }
24                dp[i] = Math.min(a, Math.min(b, c));
25                indexOnDay--;
26            }
27            else{
28                if(i+1 <= 365)
29                    dp[i] = dp[i+1];
30            }
31        }
32        return dp[1];
33    }
34}