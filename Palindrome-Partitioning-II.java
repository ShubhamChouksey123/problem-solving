1class Solution {
2
3    public int minCut(String s, int n, int[] dp, boolean[][] isPal, int end) {
4        
5        if(end < 0) return 0;
6
7        if(dp[end] != -1) return dp[end];
8
9        int minValue = Integer.MAX_VALUE;
10        for(int start = end ; start >= 0 ; start--){
11            if(s.charAt(start) == s.charAt(end) && (end - start  <= 2 || isPal[start+1][end-1]) ){
12                isPal[start][end] = true;
13                if(start == 0){
14                    minValue = 0;
15                }
16                else{
17                    minValue = Math.min(minValue, 1 + minCut(s, n, dp, isPal, start - 1));
18                }
19            }
20        }
21        dp[end] = minValue;
22        return minValue;
23    }
24
25    public int minCut(String s) {
26        int n = s.length();
27        int[] dp = new int[n];
28        Arrays.fill(dp, -1);  
29
30        boolean[][] isPal = new boolean[n][n];
31        return minCut(s, n, dp, isPal, n - 1); 
32    }
33}