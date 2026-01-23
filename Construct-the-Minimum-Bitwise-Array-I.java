1class Solution {
2
3    public int[] minBitwiseArray(List<Integer> nums) {
4        int[] result = new int[nums.size()];
5        for (int i = 0; i < nums.size(); i++) {
6            int original = nums.get(i);
7            int candidate = -1;
8            for (int j = 1; j < original; j++) {
9                if ((j | (j + 1)) == original) {
10                    candidate = j;
11                    break;
12                }
13            }
14            result[i] = candidate;
15        }
16        return result;
17    }
18}