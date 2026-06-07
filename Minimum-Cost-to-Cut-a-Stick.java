1class Solution {
2    private int minCost(int n, int[] cuts, int[][] dp, int start, int end) {
3        
4        if(start > end)
5            return 0;
6
7        if(dp[start][end] != -1)
8            return dp[start][end];
9
10        int minCost = Integer.MAX_VALUE;
11        for(int index = start ; index <= end ; index++){
12            int cost = (cuts[end + 1] - cuts[start - 1]) + minCost(n, cuts, dp, start, index - 1) + minCost(n, cuts, dp, index + 1, end);
13            minCost = Math.min(minCost, cost);
14        }
15        dp[start][end] = minCost;
16        return minCost;
17    }
18    
19    public int minCost(int n, int[] cuts) {
20        
21        Arrays.sort(cuts);
22        int[] cutsFull = new int[cuts.length + 2];
23        cutsFull[0] = 0; cutsFull[cuts.length + 1] = n;
24        for(int i = 0 ; i < cuts.length ; i++){
25            cutsFull[i+1] = cuts[i];    
26        }
27
28        int[][] dp = new int[cutsFull.length][cutsFull.length];
29        for(int[] row : dp){
30            Arrays.fill(row, -1);
31        }
32
33        return minCost(n, cutsFull, dp, 1, cuts.length);
34    }
35}