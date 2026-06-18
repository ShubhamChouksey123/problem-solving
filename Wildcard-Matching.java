1class Solution {
2    
3    private boolean isMatch(String s, String p, int n, int m, Boolean[][] memoCache, int sIndex, int pIndex) {
4        
5        // Base case
6        if(pIndex == m){
7            return sIndex == n;
8        }
9
10        if(memoCache[sIndex][pIndex] != null) return memoCache[sIndex][pIndex];
11
12        if(p.charAt(pIndex) != '*'){
13            boolean isMatchNext = false;
14            if(sIndex < n && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')){
15                isMatchNext = isMatch(s, p, n, m, memoCache, sIndex + 1, pIndex + 1) ;
16                memoCache[sIndex][pIndex] = isMatchNext;
17                return isMatchNext;
18            }
19            memoCache[sIndex][pIndex] = false;
20            return false;
21        }
22
23        boolean takeChar = false;
24        if(sIndex < n){
25            takeChar = isMatch(s, p, n, m, memoCache, sIndex + 1, pIndex) ;
26        }
27        boolean noTakeChar = isMatch(s, p, n, m, memoCache, sIndex, pIndex + 1) ;
28
29        boolean optimalValue = takeChar | noTakeChar;
30        memoCache[sIndex][pIndex] = optimalValue;
31        return optimalValue;
32    }
33    
34    public boolean isMatch(String s, String p) {
35
36        int n = s.length(), m = p.length();
37        Boolean[][] memoCache = new Boolean[n+1][m+1];
38        return isMatch(s, p, n, m, memoCache, 0, 0);
39    }
40}