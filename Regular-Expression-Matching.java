1class Solution {
2    
3    public boolean isMatch(String s, String p, int n, int m, Boolean[][] memoCache, int sIndex, int pIndex) {
4        
5        if(pIndex == p.length()){
6            return sIndex == s.length();
7        }
8        if(sIndex > n || pIndex > m) return false;
9
10        if(memoCache[sIndex][pIndex] != null)
11            return memoCache[sIndex][pIndex];
12
13        if((pIndex + 1 < m && p.charAt(pIndex + 1) != '*') || pIndex == m - 1){
14            boolean ans = false;
15            if(sIndex < n && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')){
16                ans = isMatch(s, p, n, m, memoCache, sIndex + 1, pIndex + 1);
17            }
18            memoCache[sIndex][pIndex] = ans;
19            return ans;
20        }
21
22        boolean skipChar = isMatch(s, p, n, m, memoCache, sIndex, pIndex + 2);
23        boolean takeChar = false;
24        if(sIndex < n && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')){
25            takeChar = isMatch(s, p, n, m, memoCache, sIndex + 1, pIndex);
26        }
27        
28        boolean optimalValue = skipChar || takeChar;
29        memoCache[sIndex][pIndex] = optimalValue;
30        return optimalValue; 
31    }
32    
33    public boolean isMatch(String s, String p) {
34        
35        int n = s.length(), m = p.length();
36        Boolean[][] memoCache = new Boolean[n+1][m+1];
37
38        return isMatch(s, p, n, m, memoCache, 0, 0);
39    }
40}