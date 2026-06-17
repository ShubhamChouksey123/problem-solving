1class Solution {
2
3    private int maxLength;
4    private String maxLengthSubString;
5
6    private void longestPalindrome(String s, int n, int start, int end) {
7        
8        while(start >= 0 && end < n && s.charAt(start) == s.charAt(end)){
9            if(maxLength < end - start + 1){
10                maxLengthSubString = s.substring(start, end + 1);
11                maxLength = end - start + 1;
12            }
13            start--;
14            end++;
15        }
16    }
17
18    public String longestPalindrome(String s) {
19        
20        int n = s.length();
21        maxLength = 0;
22
23        for(int i = 0 ; i < n ; i++){
24            longestPalindrome(s, n, i, i); 
25        }
26
27        for(int i = 0 ; i < n - 1 ; i++){
28            longestPalindrome(s, n, i, i + 1); 
29        }
30        return maxLengthSubString;
31    }
32}