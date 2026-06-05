1class Solution {
2
3    private int numDistinct(String s, String t, int[][] dp, int indexS, int indexT) {
4
5        if(indexS == s.length() && indexT < t.length()){
6            return 0;
7        }
8        
9        if(indexT == t.length())
10            return 1;
11
12        if(dp[indexS][indexT] != -1){
13            return dp[indexS][indexT];
14        }
15
16
17        if(s.charAt(indexS) != t.charAt(indexT)){
18            dp[indexS][indexT] = numDistinct(s, t, dp, indexS + 1, indexT); 
19            return dp[indexS][indexT];
20        }
21
22        int a = numDistinct(s, t, dp, indexS + 1, indexT + 1);
23        int b = numDistinct(s, t, dp, indexS + 1, indexT);
24        
25        int optimalValue = a + b;
26        dp[indexS][indexT] = optimalValue;
27        return optimalValue;
28    }
29
30    public int numDistinct(String s, String t) {
31        
32        if(s.length() < t.length()){
33            return 0;
34        }
35
36        int[][] dp = new int[s.length()][t.length()];
37        for(int[] row : dp){
38            Arrays.fill(row, -1);
39        }
40        return numDistinct(s, t, dp, 0, 0);
41    }
42}