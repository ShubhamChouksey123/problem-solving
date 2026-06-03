1class Solution {
2    public int countSubstrings(String s) {
3
4        int n = s.length();
5        boolean[][] dp = new boolean[n][n];
6
7        int countPalindrome = n;
8
9        // length : 1 string, every 1 length string is a palindrome
10        for(int i = 0; i < n ; i++){
11            dp[i][i] = true;
12        }
13
14        // length : 2 string
15        for(int i = 0 ; i < n - 1; i++){
16            if(s.charAt(i) == s.charAt(i+1)){
17                dp[i][i+1] = true;
18                countPalindrome++;
19            }
20        }
21
22        for(int len = 3 ; len <= n ; len++){
23            for(int startIndex = 0 ; startIndex < n - len + 1 ; startIndex++){
24                int endIndex = startIndex + len - 1;
25                if(s.charAt(startIndex) == s.charAt(endIndex) && dp[startIndex + 1][endIndex - 1]){
26                    dp[startIndex][endIndex] = true;
27                    countPalindrome++;
28                }
29            }
30        }
31        return countPalindrome;
32        
33    }
34}