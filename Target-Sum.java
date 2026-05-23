1class Solution {
2    
3    private Map<Pair<Integer, Integer> , Integer> memo;
4
5    private int countWays(int[] nums, int target, int index, int sum) {
6
7        if(index == nums.length){
8            return (sum == target) ? 1 : 0;
9        }
10        Pair<Integer, Integer> pair = new Pair<>(index, sum);
11        if(memo.containsKey(pair)){
12            return memo.get(pair);
13        }
14
15        int addWays = countWays(nums, target, index + 1, sum + nums[index]);
16        int subWays = countWays(nums, target, index + 1, sum - nums[index]);
17        
18        int totalWays = addWays + subWays;
19        memo.put(pair, totalWays);
20        return totalWays;
21    }
22    
23    public int findTargetSumWays(int[] nums, int target) {
24
25        int n = nums.length;
26        int maxValue = 0;
27        for(int num : nums){
28            maxValue += num;
29        }
30
31        memo = new HashMap<>();
32        
33        return countWays(nums, target, 0, 0);
34    }
35}