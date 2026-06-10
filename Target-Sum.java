1class Solution {
2
3    Map<Pair<Integer, Integer>, Integer> mp;
4    public int findTargetSumWays(int[] nums, int target, int index, int sum) {
5
6        if(index >= nums.length){
7            if(sum == target) 
8                return 1;
9            return 0;
10        }
11
12        Pair<Integer, Integer> key = new Pair<>(index, sum);
13         if(mp.containsKey(key)) 
14            return mp.get(key);
15
16
17        int a = findTargetSumWays(nums, target, index + 1, sum - nums[index]);
18        int b = findTargetSumWays(nums, target, index + 1, sum + nums[index]);
19
20        mp.put(key, a + b);
21        return a + b;
22    }
23
24    public int findTargetSumWays(int[] nums, int target) {
25        int n = nums.length;
26        mp = new HashMap<>();
27        return findTargetSumWays(nums, target, 0, 0); 
28    }
29}  