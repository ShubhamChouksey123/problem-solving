1class Solution {
2    
3    public int longestPalindromeSubseq(String s, int n, int[][] memoCache , int start, int end) {
4        
5        if(start == end) return 1;
6        if(start > end) return 0;
7
8        if(memoCache[start][end] != -1) return memoCache[start][end];
9
10        int longestPalLength = 1;
11        if(s.charAt(start) == s.charAt(end)){
12            longestPalLength = 2 + longestPalindromeSubseq(s, n, memoCache , start + 1, end - 1); 
13        }
14        else{
15            longestPalLength = Math.max(
16                longestPalindromeSubseq(s, n, memoCache , start + 1, end),
17                longestPalindromeSubseq(s, n, memoCache , start, end - 1)
18            );
19        }
20        memoCache[start][end] = longestPalLength;
21        return longestPalLength;
22    }
23    
24    public int longestPalindromeSubseq(String s) {
25
26        int n = s.length();
27        int[][] memoCache = new int[n][n];
28        for(int[] row : memoCache){
29            Arrays.fill(row, -1);
30        }
31        
32        return longestPalindromeSubseq(s, n, memoCache , 0, n - 1); 
33    }
34}