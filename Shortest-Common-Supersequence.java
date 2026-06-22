1class Solution {
2    public String shortestCommonSupersequence(String str1, String str2) {
3        
4        int n = str1.length(), m = str2.length();
5        int[][] dp = new int[n+1][m+1];
6
7        for(int i = 1 ; i <= n ; i++){
8            dp[i][0] = i;
9        }
10        for(int j = 1 ; j <= m ; j++){
11            dp[0][j] = j;
12        }
13
14        for(int i = 1 ; i <= n ; i++){
15            for(int j = 1 ; j <= m ; j++){
16                if(str1.charAt(i-1) == str2.charAt(j-1)){
17                    dp[i][j]= 1 + dp[i-1][j-1];
18                }else{
19                    dp[i][j]= 1 + Math.min(dp[i][j-1], dp[i-1][j]);
20                }
21            }
22        }
23
24        int i = n , j = m;
25
26        StringBuilder builder = new StringBuilder();
27        while(i >= 1 && j >= 1){
28            if(str1.charAt(i-1) == str2.charAt(j-1)){
29                builder.append(str1.charAt(i - 1));
30                i--;
31                j--;
32            }
33            else if(dp[i-1][j] <= dp[i][j-1]){
34                builder.append(str1.charAt(i - 1));
35                i--;
36            }else{
37                builder.append(str2.charAt(j - 1));
38                j--;
39            }
40        }
41
42        while(i >= 1){
43            builder.append(str1.charAt(i - 1));
44            i--;
45        }
46
47        while(j >= 1){
48            builder.append(str2.charAt(j - 1));
49            j--;
50        }
51
52        String ans = builder.reverse().toString();
53
54        return ans;
55    }
56}