1class Solution {
2    public int findNumberOfLIS(int[] nums) {
3        int n = nums.length;
4        int[] dp = new int[n];
5        int[] count = new int[n];
6        Arrays.fill(dp, 1);
7        Arrays.fill(count, 1);
8
9        int maxLength = 1; 
10
11        for(int i = 1 ; i < n ; i++){
12            for(int j = 0 ; j < i ; j++){
13                if(nums[j] < nums[i]){
14                    if( dp[i] < 1 + dp[j] ){
15                        dp[i] = 1 + dp[j];
16                        count[i] = count[j];   
17                    }
18                    else if( dp[i] == 1 + dp[j] ){
19                        count[i] += count[j];   
20                    }
21                }
22            }
23            maxLength = Math.max(maxLength, dp[i]);
24        }
25
26        int numberOfLCS = 0;
27        for(int index = 0 ; index < n ; index++ ){
28            if(dp[index] == maxLength){
29                numberOfLCS += count[index];
30            }
31        }
32
33        return numberOfLCS;
34    }
35}