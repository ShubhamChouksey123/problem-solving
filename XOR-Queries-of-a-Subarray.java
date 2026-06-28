1class Solution {
2    
3    private void precompute(int[] dp, int[] arr){
4        dp[0] = arr[0];
5        for(int i = 1 ; i < arr.length ; i++){
6            dp[i] = dp[i-1] ^ arr[i];   
7        }
8    }
9    public int[] xorQueries(int[] arr, int[][] queries) {
10        
11        int n = arr.length;
12        // dp[i] represent XOR from arr[0] ^ arr[1] ^ ... ^ arr[i]
13        int[] dp = new int[n];
14
15        precompute(dp, arr);
16
17        int[] result = new int[queries.length];
18        for(int i = 0 ; i < queries.length ; i++ ){
19            int[] query = queries[i];
20            int start = query[0], end = query[1];
21            if(start == 0){
22                result[i] = dp[end];
23            }
24            else{
25                result[i] = dp[end] ^ dp[start - 1];
26            }
27        }
28        return result;
29    }
30}