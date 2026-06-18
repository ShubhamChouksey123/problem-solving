1class Solution {
2    public String shortestCommonSupersequence(String str2, String str1) {
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
17                    dp[i][j] = 1 + dp[i-1][j-1];
18                }else{
19                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
20                }
21            }
22            System.out.println(Arrays.toString(dp[i]));
23        }
24
25
26        int i = n, j = m;
27        StringBuilder builder = new StringBuilder();  
28        while(i >= 1 && j >= 1){
29            System.out.println("i : " + i + ", j : " + j);
30            
31            if(str1.charAt(i-1) == str2.charAt(j-1)){
32                builder.append(str1.charAt(i-1));
33                i--; j--;
34            }
35            else if(dp[i-1][j] > dp[i][j-1]){
36                builder.append(str2.charAt(j-1));
37                j--;
38            }
39            else {
40                builder.append(str1.charAt(i-1));
41                i--;
42            }
43            System.out.println(builder.toString());
44        }
45
46        while(i > 0){
47            builder.append(str1.charAt(i-1));
48            i--;
49        }
50        while(j > 0){
51            builder.append(str2.charAt(j-1));
52            j--;
53        }
54
55        String ans = builder.reverse().toString();
56        return ans;
57    }
58}