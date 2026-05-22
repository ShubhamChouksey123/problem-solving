1class Solution {
2
3    private int[][] memo;
4
5    private int maxSum(int[] stones, int index, int target){
6
7        if(index == stones.length){
8            return 0;
9        }
10
11        if(memo[index][target] != -1){
12            return memo[index][target];
13        }
14
15        int exclude = maxSum(stones, index + 1, target);
16        int include = 0;
17        if(target >= stones[index]){
18            include = stones[index] + maxSum(stones, index + 1, target - stones[index]);
19        }
20
21        memo[index][target] = Math.max(include, exclude);
22        return memo[index][target];
23    }
24
25    public int lastStoneWeightII(int[] stones) {
26
27        int totalSum = 0, n = stones.length;
28        for(int stone : stones){
29            totalSum += stone;
30        }       
31
32        int target = totalSum / 2;
33        memo = new int[n + 1][target + 1];
34
35        for(int i = 0 ; i <= n ; i++){
36            Arrays.fill(memo[i], -1);
37        }
38
39        int s1 = maxSum(stones, 0, target);
40
41        return totalSum - (2 * s1);
42    }
43}