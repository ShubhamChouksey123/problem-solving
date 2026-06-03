1class Solution {
2    
3    public int countSubstrings(String s, int n , int start, int end) {
4
5        int count = 0;
6        while(start >= 0 && end < n && s.charAt(start) == s.charAt(end)){
7            count++;
8            start--;
9            end++;
10        }
11        return count;
12    }
13    
14    public int countSubstrings(String s) {
15
16        int n = s.length();
17        int count = 0;
18
19        // odd length palindrome
20        for(int i = 0 ; i < n ; i++){
21            count += countSubstrings(s, n , i, i); 
22        }
23
24        // odd length palindrome
25        for(int i = 0 ; i < n - 1 ; i++){
26            count += countSubstrings(s, n , i, i + 1); 
27        }
28
29        return count;
30    
31    }
32}