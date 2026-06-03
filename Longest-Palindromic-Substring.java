1class Solution {
2    
3    private String maxPalindrome;
4    private int maxPalindromeLength;
5
6    private void getMaxLengthPalinrome(String s, int n, int start, int end){
7
8        while(start >= 0 && end < n && s.charAt(start) == s.charAt(end)){
9            int length = end - start + 1; 
10            if(length > maxPalindromeLength){
11                maxPalindrome = s.substring(start, end + 1);
12                maxPalindromeLength = length;
13            }
14            start--;
15            end++;  
16        }
17    }
18    
19    public String longestPalindrome(String s) {
20
21        int n = s.length();
22        maxPalindromeLength = 0;
23
24        // odd length palindromes
25        for(int i = 0 ; i < n ; i++){
26            getMaxLengthPalinrome(s, n, i, i);
27        }    
28
29        // even length palindromes
30        for(int i = 0 ; i < n - 1; i++){
31            getMaxLengthPalinrome(s, n, i, i + 1);
32        }
33        return maxPalindrome ;
34    }
35}