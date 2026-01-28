1class Solution {
2    public long maximumSubarraySum(int[] nums, int k) {
3
4        int n = nums.length, size = 0, startIndex = 0, countDistinct = 0;
5        long curSum = 0, maxSum = 0;
6        Map<Integer, Integer> map = new HashMap<>(); 
7
8
9        for(int i = 0 ; i < n ; i++){
10            int cur = nums[i];  
11            curSum += nums[i];
12
13            if(i >= k){
14                int count = map.get(nums[i-k]);
15                if(count > 1){
16                    map.put(nums[i-k], --count);
17                }else{
18                    map.remove(nums[i-k]);
19                    countDistinct--;
20                }
21                curSum -= nums[i-k];
22            }
23            
24            if(!map.containsKey(cur)){
25                countDistinct++;
26                map.put(cur, 1);
27            }else{
28                int count = map.get(cur);
29                map.replace(cur, ++count);
30            }
31            if(countDistinct == k){
32                maxSum = Math.max(maxSum, curSum);
33            }
34        }
35
36        return maxSum;
37    }
38}