1class Solution {
2    public List<Integer> largestDivisibleSubset(int[] nums) {
3
4        int n = nums.length;
5        Arrays.sort(nums);
6
7        int[] dp = new int[n];
8        int[] parent = new int[n];
9        Arrays.fill(dp, 1);
10        Arrays.fill(parent, -1);
11
12        int maxSubsetSize = 1, maxSubsetIndex = 0;
13        for(int i = 1 ; i < n ; i++){
14            for(int j = 0 ; j < i ; j++){
15                if(nums[j] < nums[i] && nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i] ){
16                    dp[i] = 1 + dp[j];
17                    parent[i] = j;
18                }
19            }
20            if(dp[i] > maxSubsetSize){
21                maxSubsetSize = dp[i];
22                maxSubsetIndex = i;
23            }
24        }
25
26        List<Integer> ans = new ArrayList<>();
27        int index = maxSubsetIndex;
28
29        while(index != -1){
30            ans.add(nums[index]);
31            index = parent[index];
32        }
33        return ans;
34        
35    }
36}