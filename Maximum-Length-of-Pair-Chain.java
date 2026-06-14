1class Solution {
2    public int findLongestChain(int[][] pairs) {
3        Arrays.sort(pairs, 
4            (a, b) -> Integer.compare(a[0], b[0])
5        );
6
7        int n = pairs.length;
8        int[] dp = new int[n];
9        Arrays.fill(dp, 1);
10
11        int maxValue = 1;
12        for(int i = 1 ; i < n ; i++){
13            for(int j = 0 ; j < i ; j++){
14                if(pairs[j][1] < pairs[i][0]){
15                    dp[i] = Math.max(dp[i], 1 + dp[j]);
16                }
17            }
18            maxValue = Math.max(maxValue, dp[i]);
19        }
20        return maxValue;
21    }
22}