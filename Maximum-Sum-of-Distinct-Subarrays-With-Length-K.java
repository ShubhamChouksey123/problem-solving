1class Solution {
2    public long maximumSubarraySum(int[] nums, int k) {
3
4        int n = nums.length;
5        Map<Integer, Integer> countOfElemets = new HashMap<>();
6        long sum = 0, maxSum = 0;
7
8        for(int i = 0 ; i < k ; i++){
9            countOfElemets.put(nums[i], countOfElemets.getOrDefault(nums[i], 0) + 1);
10            sum += nums[i];
11        }
12        if( countOfElemets.size() == k){
13            maxSum = Math.max(maxSum, sum);
14        }
15
16        for(int i = k ; i < n ; i++){
17            sum -= nums[i-k];
18            int currentOccuranceFirstElement = countOfElemets.get(nums[i-k]);
19            if(currentOccuranceFirstElement == 1){
20                countOfElemets.remove(nums[i-k]);
21            }else{
22                countOfElemets.put(nums[i-k], currentOccuranceFirstElement - 1);
23            }
24            
25
26            sum += nums[i];
27            int currentOccurance = countOfElemets.getOrDefault(nums[i], 0);
28            countOfElemets.put(nums[i], currentOccurance + 1);
29            if(currentOccurance == 0 && countOfElemets.size() == k){
30                maxSum = Math.max(maxSum, sum);
31            }
32        }
33
34        return maxSum;
35        
36    }
37}