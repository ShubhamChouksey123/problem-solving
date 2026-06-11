1class Solution {
2
3    private int countZeros(String str){
4        int count = 0;
5        for(char c : str.toCharArray()){
6            if(c == '0') count++;
7        }
8        return count;
9    }
10    
11    private int findMaxForm(String[] strs, int[][][] dp, int m, int n, int index) {
12        
13        if(index == strs.length){
14            return 0;
15        }
16        if(m == 0 && n == 0) return 0;
17
18        if(dp[m][n][index] != -1)
19            return dp[m][n][index];
20
21        int countZeros = countZeros(strs[index]);
22        int countOnes = strs[index].length() - countZeros;
23
24        int a = 0;
25        if(countZeros <= m && countOnes <= n){
26            a = 1 + findMaxForm(strs, dp, m - countZeros , n - countOnes, index + 1);
27        }
28        int b = findMaxForm(strs, dp, m , n, index + 1);
29
30        int optimalValue = Math.max(a, b);
31        dp[m][n][index] = optimalValue;
32        return optimalValue;
33    }
34    
35    public int findMaxForm(String[] strs, int m, int n) {
36        
37        int totalStrings = strs.length;
38        int[][][] dp = new int[m+1][n+1][totalStrings];
39        for(int[][] matrix : dp){
40            for(int[] row : matrix){
41                Arrays.fill(row, -1);
42            }
43        }
44
45        return findMaxForm(strs, dp, m, n, 0);
46    }
47}