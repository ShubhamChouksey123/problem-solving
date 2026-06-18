1class Solution {
2    
3    public boolean isMatch(String s, String p) {
4
5        int n = s.length(), m = p.length();
6        boolean[][] memoCache = new boolean[n+1][m+1];
7
8        memoCache[0][0] = true;
9        for(int j = 1 ; j <= m ; j++){
10            if(p.charAt(j-1) != '*')  {
11                memoCache[0][j] = false;
12            }
13            else{
14                memoCache[0][j] = memoCache[0][j-1];
15            }
16        }
17
18        for(int i = 1 ; i <= n ; i++){
19            for(int j = 1 ; j <= m ; j++){
20                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
21                    memoCache[i][j] = memoCache[i-1][j-1];
22                }
23                else if(p.charAt(j-1) == '*'){
24                    memoCache[i][j] = memoCache[i][j-1] || memoCache[i-1][j];
25                }
26            }
27        }
28
29        return memoCache[n][m];
30    }
31}