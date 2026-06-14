1class Solution {
2    
3    public int mincostTickets(int[] days, int[] costs) {
4        
5        int n = days.length;
6        int[] dp = new int[366 + 30];
7
8        int indexOnDay = n - 1;
9        int a, b, c;
10        for(int i = days[indexOnDay] ; i >= 1 ; i--){
11            if(indexOnDay >= 0 && days[indexOnDay] == i){
12                // we might need to purchase ticket
13                a = costs[0] + dp[i+1];
14                b = costs[1] + dp[i+7];
15                c = costs[2] + dp[i+30];
16
17                dp[i] = Math.min(a, Math.min(b, c));
18                indexOnDay--;
19            }
20            else{
21                dp[i] = dp[i+1];
22            }
23        }
24        return dp[1];
25    }
26}