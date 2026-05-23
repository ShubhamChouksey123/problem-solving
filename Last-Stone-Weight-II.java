1class Solution {
2
3    private int[][] memo;
4
5    private int maxSum(int[] stones, int target, int index, int sum){
6
7        if(index == stones.length){
8            return sum;
9        }
10
11        if(sum > target){
12            return 0;
13        }
14
15        if(memo[index][sum] != -1){
16            return memo[index][sum];
17        }
18
19        int exclude = maxSum(stones, target, index + 1, sum);
20
21        int include = 0;
22        if(target - sum >= stones[index]){
23            include = maxSum(stones, target, index + 1, sum + stones[index]);
24        }
25        
26        memo[index][sum] = Math.max(include, exclude);
27        return memo[index][sum];
28    }
29
30    public int lastStoneWeightII(int[] stones) {
31
32        int n = stones.length;
33        int totalValue = 0;
34
35        for(int stone : stones){
36            totalValue += stone;
37        }
38        int target = totalValue / 2;
39        memo = new int[n][target + 1];
40        for(int[] row : memo){
41            Arrays.fill(row, -1);
42        }
43
44        int s1 = maxSum(stones, target, 0, 0);
45        
46        return totalValue - 2 * s1;
47    }
48}