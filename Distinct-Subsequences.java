1class Solution {
2    
3    private int numDistinct(String s, String t, int n, int m, int[][] memoCache, int index1, int index2) {
4        
5        if(index1 == n && index2 == m) return 1;
6        if(index1 >= n && index2 < m) return 0;
7
8        if(memoCache[index1][index2] != -1) return memoCache[index1][index2];
9
10        if(index1 < n && index2 == m){
11            int ans = numDistinct(s, t, n, m, memoCache, index1 + 1, index2);
12            memoCache[index1][index2] = ans; 
13            return ans;
14        }
15
16        if(index1 < n && index2 < m && s.charAt(index1) != t.charAt(index2)){
17            int ans = numDistinct(s, t, n, m, memoCache, index1 + 1, index2);
18            memoCache[index1][index2] = ans; 
19            return ans;
20        }
21
22        int a = numDistinct(s, t, n, m, memoCache, index1 + 1, index2 + 1);
23        int b = numDistinct(s, t, n, m, memoCache, index1 + 1, index2);
24        
25        
26        int optimalValue = a + b;
27        memoCache[index1][index2] = optimalValue;
28        return optimalValue;
29    }
30    
31    public int numDistinct(String s, String t) {
32        
33        int n = s.length(), m = t.length();
34        int[][] memoCache = new int[n+1][m+1];
35        for(int[] row : memoCache){
36            Arrays.fill(row , -1);
37        }
38
39        return numDistinct(s, t, n, m, memoCache, 0, 0);
40    }
41}