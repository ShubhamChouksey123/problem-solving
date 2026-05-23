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
11        if(memo[index][sum] != -1){
12            return memo[index][sum];
13        }
14
15        int exclude = maxSum(stones, target, index + 1, sum);
16
17        int include = 0;
18        if(target - sum >= stones[index]){
19            include = maxSum(stones, target, index + 1, sum + stones[index]);
20        }
21        
22        memo[index][sum] = Math.max(include, exclude);
23        return memo[index][sum];
24    }
25
26    public int lastStoneWeightII(int[] stones) {
27
28        int n = stones.length;
29        int totalValue = 0;
30
31        for(int stone : stones){
32            totalValue += stone;
33        }
34        int target = totalValue / 2;
35        memo = new int[n][target + 1];
36        for(int[] row : memo){
37            Arrays.fill(row, -1);
38        }
39
40        int s1 = maxSum(stones, target, 0, 0);
41        
42        return totalValue - 2 * s1;
43    }
44}