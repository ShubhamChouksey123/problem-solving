1class Solution {
2    
3    public boolean isMatch(String s, String p, int n, int m, Boolean[][] memoCache, int index1, int index2) {
4        
5        
6        if(index2 == p.length()){
7            return index1 == s.length();
8        }
9        if(index1 > s.length() || index2 > p.length()) return false;
10
11
12        if(memoCache[index1][index2] != null)
13            return memoCache[index1][index2];
14        
15        if((index2 + 1 < m && p.charAt(index2 + 1) != '*') || index2 == m - 1 ){
16            if((index1 < n && s.charAt(index1) == p.charAt(index2)) || p.charAt(index2) == '.'){
17                boolean ans = isMatch(s, p, n, m, memoCache, index1 + 1, index2 + 1) ;
18                memoCache[index1][index2] = ans;
19                return ans;
20            }
21            memoCache[index1][index2] = false;
22            return false;
23        }
24
25        boolean takeChar = false;
26        if(index1 < n && index2 < m && (s.charAt(index1) == p.charAt(index2) || p.charAt(index2) == '.' ) ){
27            takeChar = isMatch(s, p, n, m, memoCache, index1 + 1, index2);
28        }
29
30        boolean noTakeChar = isMatch(s, p, n, m, memoCache, index1, index2 + 2);
31        boolean ans = takeChar || noTakeChar;
32        memoCache[index1][index2] = ans;
33        return ans; 
34    }
35    
36    public boolean isMatch(String s, String p) {
37
38        int n = s.length(), m = p.length();
39        Boolean[][] memoCache = new Boolean[n+1][m+1];
40        return isMatch(s, p, n, m, memoCache, 0, 0);    
41    }
42}