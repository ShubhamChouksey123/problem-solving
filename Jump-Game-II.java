1class Solution {
2    public int jump(int[] nums) {
3
4        int n = nums.length;
5        if(n <= 1) return 0;
6
7        int currentEnd = 0;
8        int farthest = 0;
9        int jumps = 0;
10
11        for(int i = 0 ; i < n; i++){
12
13            farthest = Math.max(farthest, i + nums[i]);
14
15            if(i == currentEnd){
16                jumps++;
17                currentEnd = farthest;
18
19                if(farthest >= n - 1) break;
20            }
21        }
22
23        return jumps;
24        
25    }
26}