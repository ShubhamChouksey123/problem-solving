1class Solution {
2    public int[] xorQueries(int[] arr, int[][] queries) {
3        int n = arr.length;
4        int[] xors = new int[n];
5
6        xors[0] = arr[0];
7        for(int i = 1 ; i < n ; i++){
8            xors[i] = xors[i-1] ^ arr[i];
9        }
10
11
12        int[] ans = new int[queries.length];
13        for(int i = 0 ; i < queries.length; i++){
14            if(queries[i][0] > 0){
15                ans[i] = xors[queries[i][1]] ^ xors[queries[i][0] - 1];
16            }
17            else{
18                ans[i] = xors[queries[i][1]];
19            }
20            
21        }  
22        return ans;
23        
24    }
25}