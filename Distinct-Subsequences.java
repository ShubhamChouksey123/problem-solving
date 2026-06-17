1class Solution {
2    
3    private int numDistinct(String s, String t, int n, int m, int[][] memoCache, int index1, int index2) {
4
5        if(index2 == m) return 1;
6
7        if(index1 == n) return 0;        
8
9        if(memoCache[index1][index2] != -1) return memoCache[index1][index2];
10
11        if(s.charAt(index1) != t.charAt(index2)){
12            int ans = numDistinct(s, t, n, m, memoCache, index1 + 1, index2);
13            memoCache[index1][index2] = ans; 
14            return ans;
15        }
16
17        int a = numDistinct(s, t, n, m, memoCache, index1 + 1, index2 + 1);
18        int b = numDistinct(s, t, n, m, memoCache, index1 + 1, index2);
19        
20        
21        int optimalValue = a + b;
22        memoCache[index1][index2] = optimalValue;
23        return optimalValue;
24    }
25    
26    public int numDistinct(String s, String t) {
27        
28        int n = s.length(), m = t.length();
29
30        if(n < m) return 0;
31        int[][] memoCache = new int[n+1][m+1];
32        for(int[] row : memoCache){
33            Arrays.fill(row , -1);
34        }
35
36        return numDistinct(s, t, n, m, memoCache, 0, 0);
37    }
38}