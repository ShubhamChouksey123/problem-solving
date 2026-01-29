1class Solution {
2
3    private boolean equals(String s1, String s2){
4        int[] charCountS1 = new int[26];
5        int[] charCountS2 = new int[26];
6
7        for(char c : s1.toCharArray()){
8            charCountS1[c-'a']++;
9        }
10        for(char c : s2.toCharArray()){
11            charCountS2[c-'a']++;
12        }
13
14        for(int i = 0 ; i < 26 ; i++){
15            if(charCountS1[i] != charCountS2[i]){
16                return false;
17            }
18        }
19        return true;
20    }
21
22    public boolean checkInclusion(String s1, String s2) {
23
24        int n1 = s1.length(), n2 = s2.length();
25        // if(n1 > n2){
26        //     return false;
27        // }
28
29        for(int i = 0 ; i <= n2 - n1 ; i++){
30            String subString = s2.substring(i, i + n1);
31            if(equals(s1, subString)){
32                return true;
33            }
34        }
35        return false;
36
37    }
38}