1class Solution {
2    
3    private int[][][] memo;
4
5    private int countZeros(String s){
6        int count = 0;
7        for(char c : s.toCharArray()){
8            if(c == '0') count++;
9        }
10        return count;
11    }
12
13    private int findMaxFormUtil(String[] strs, int index, int m, int n) {
14        
15        if(m < 0 || n < 0) return Integer.MIN_VALUE;
16
17        if(index == strs.length){
18            return 0; 
19        }
20
21        if(memo[index][m][n] != -1){
22            return memo[index][m][n];
23        }
24
25        String s = strs[index];
26        int zeroCount = countZeros(s);
27        int oneCount = s.length() - zeroCount;
28
29        int a = 1 + findMaxFormUtil(strs, index + 1, m - zeroCount, n - oneCount);
30        int b = findMaxFormUtil(strs, index + 1, m, n);
31        
32        int max = Math.max(a, b);
33        memo[index][m][n] = max;
34        
35        return max;
36    }
37    
38    public int findMaxForm(String[] strs, int m, int n) {
39        int len = strs.length;
40        memo = new int[len + 1][m+1][n+1];
41        for(int i = 0 ; i <= len ; i++){
42            for(int j = 0 ; j <= m ; j++){
43                Arrays.fill(memo[i][j], -1);
44            }
45        }
46        return findMaxFormUtil(strs, 0, m, n);
47    }
48}