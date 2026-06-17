1class Solution {
2    
3    public int longestCommonSubsequence(String text1, String text2, int[][] memoCache, int index1, int index2) {
4        
5        if(index1 < 0 || index2 < 0) return 0;
6
7        if(memoCache[index1][index2] != -1) return memoCache[index1][index2]; 
8
9        int ans = 0;
10        if(text1.charAt(index1) == text2.charAt(index2)){
11            ans = 1 + longestCommonSubsequence(text1, text2, memoCache, index1 - 1, index2 - 1);
12        }
13        else{
14            ans = Math.max(
15                longestCommonSubsequence(text1, text2, memoCache, index1, index2 - 1),
16                longestCommonSubsequence(text1, text2, memoCache, index1 - 1, index2)
17            );
18        }
19        memoCache[index1][index2] = ans;
20        return ans;
21
22    }
23    
24    public int longestCommonSubsequence(String text1, String text2) {
25
26        int n = text1.length(), m = text2.length();
27        int[][] memoCache = new int[n][m];
28        for(int[] row : memoCache){
29            Arrays.fill(row, -1);
30        }
31
32
33        return longestCommonSubsequence(text1, text2, memoCache, n - 1, m - 1);
34    }
35}