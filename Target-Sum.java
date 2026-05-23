1class Solution {
2    
3    private int[][] memo;
4    private int maxValue;
5
6    
7    public int findTargetSumWays(int[] nums, int target) {
8
9        int n = nums.length;
10        maxValue = 0;
11        
12        for(int num : nums){
13            maxValue += num;
14        }
15
16        if(target < -maxValue || target > maxValue)
17            return 0;
18
19        memo = new int[n+1][ 2 * maxValue + 1];
20        for(int[] row : memo){
21            Arrays.fill(row, 0);
22        }
23        memo[0][0 + maxValue] = 1; 
24
25        for(int i = 1 ; i <= n ; i++){
26            int num = nums[i-1];
27            for(int j = 0 ; j <= 2 * maxValue ; j++){
28                if(memo[i-1][j] > 0){
29                    memo[i][j + num] += memo[i-1][j] ;
30                    memo[i][j - num] += memo[i-1][j] ;
31                }                
32            }
33        }
34        return memo[n][target + maxValue];
35    }
36}