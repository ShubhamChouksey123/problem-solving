1class Solution {
2    private int minimumDeleteSum(String s1, String s2, int[][] memoCache, int length1, int length2) {
3        
4        if(length1 == 0 && length2 == 0) return 0;
5
6        if(memoCache[length1][length2] != -1){
7            return memoCache[length1][length2];
8        }
9
10        int ans = 0;
11        if(length1 > 0 && length2 > 0 && s1.charAt(length1 - 1) == s2.charAt(length2 - 1)){
12            ans = minimumDeleteSum(s1, s2, memoCache, length1 - 1, length2 - 1);
13        }
14        else{
15            int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
16            if(length2 > 0){
17                a = s2.charAt(length2 - 1) + minimumDeleteSum(s1, s2, memoCache, length1, length2 - 1);
18            }
19            if(length1 > 0){
20                b = s1.charAt(length1 - 1) + minimumDeleteSum(s1, s2, memoCache, length1 - 1, length2);
21            }
22            ans = Math.min(a, b);
23        }
24        memoCache[length1][length2] = ans;
25        return ans;
26    }
27
28    public int minimumDeleteSum(String s1, String s2){
29
30        int n = s1.length(), m = s2.length();
31        int[][] memoCache = new int[n+1][m+1];
32        for(int[] row : memoCache){
33            Arrays.fill(row, -1);
34        }
35
36        return minimumDeleteSum(s1, s2, memoCache, n, m); 
37    }
38}