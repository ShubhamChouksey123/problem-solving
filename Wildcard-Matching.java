1class Solution {
2    
3    public boolean isMatch(String s, String p, int n, int m, Boolean[][] memoCache, int sIndex, int pIndex) {
4        
5        if(pIndex == m){
6            return sIndex == n;
7        }
8        if(sIndex > n) return false;
9        if(memoCache[sIndex][pIndex] != null){
10            return memoCache[sIndex][pIndex];
11        }
12
13        if(p.charAt(pIndex) != '*'){
14            if(sIndex < n && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')){
15                boolean ans = isMatch(s, p, n, m, memoCache, sIndex + 1, pIndex + 1);
16                memoCache[sIndex][pIndex] = ans;
17                return ans;
18            }
19            memoCache[sIndex][pIndex] = false;
20            return false;
21        }
22
23        boolean notTake = false;
24        if(pIndex < m){
25            notTake = isMatch(s, p, n, m, memoCache, sIndex, pIndex + 1); 
26        }
27        
28        boolean takeChar = false;
29        if(sIndex < n){
30            takeChar = isMatch(s, p, n, m, memoCache, sIndex + 1, pIndex); 
31        }
32        
33
34        boolean optimalValue = notTake || takeChar;
35        memoCache[sIndex][pIndex] = optimalValue;
36        return optimalValue;
37    }
38    
39    public boolean isMatch(String s, String p) {
40
41        int n = s.length(), m = p.length();
42        Boolean[][] memoCache = new Boolean[n+1][m+1];
43        return isMatch(s, p, n, m, memoCache, 0, 0);    
44    }
45}