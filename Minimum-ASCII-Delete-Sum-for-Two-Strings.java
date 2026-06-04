1class Solution {
2    public int minimumDeleteSum(String s1, String s2) {
3
4        int n = s1.length(), m = s2.length();
5        int[] prev = new int[m+1];
6        int[] curr = new int[m+1];
7
8
9
10        for(int j = 1 ; j <= m ; j++){
11            prev[j] = prev[j-1] + (int)s2.charAt(j-1); 
12        }
13
14        for(int i = 1 ; i <= n ; i++){
15            
16            curr[0] = prev[0] + (int)s1.charAt(i-1); 
17            for(int j = 1 ; j <= m ; j++){
18
19                if(s1.charAt(i-1) == s2.charAt(j-1)){
20                    curr[j] = prev[j-1];
21                }
22                else{
23                    curr[j] = Math.min(
24                        prev[j] + (int)s1.charAt(i-1),
25                        curr[j-1] + (int)s2.charAt(j-1)
26                    );
27                }
28            }
29
30            int[] temp = prev;
31            prev = curr;
32            curr = temp;
33
34        }
35        return prev[m];
36    }
37}