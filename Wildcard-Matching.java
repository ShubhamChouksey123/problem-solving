1class Solution {
2    
3    private boolean isMatch(String s, String p, int n, int m, Boolean[][] memoCache, int sIndex, int pIndex) {
4        
5        // Base case
6        if(pIndex == m){
7            return sIndex == n;
8        }
9        if(sIndex > n && pIndex < m) return false;
10
11        if(memoCache[sIndex][pIndex] != null) return memoCache[sIndex][pIndex];
12
13        if(p.charAt(pIndex) != '*'){
14            boolean isMatchNext = false;
15            if(sIndex < n && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')){
16                isMatchNext = isMatch(s, p, n, m, memoCache, sIndex + 1, pIndex + 1) ;
17                memoCache[sIndex][pIndex] = isMatchNext;
18                return isMatchNext;
19            }
20            memoCache[sIndex][pIndex] = false;
21            return false;
22        }
23
24        boolean takeChar = isMatch(s, p, n, m, memoCache, sIndex + 1, pIndex) ;
25        boolean noTakeChar = isMatch(s, p, n, m, memoCache, sIndex, pIndex + 1) ;
26
27        boolean optimalValue = takeChar | noTakeChar;
28        memoCache[sIndex][pIndex] = optimalValue;
29        return optimalValue;
30    }
31    
32    public boolean isMatch(String s, String p) {
33
34        int n = s.length(), m = p.length();
35        Boolean[][] memoCache = new Boolean[n+1][m+1];
36        return isMatch(s, p, n, m, memoCache, 0, 0);
37    }
38}