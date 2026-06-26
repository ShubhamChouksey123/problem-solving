1class Solution {
2    public int wiggleMaxLength(int[] nums) {
3
4        int n = nums.length;
5
6        int[] up = new int[n];
7        int[] down = new int[n];
8        Arrays.fill(up, 1);
9        Arrays.fill(down , 1);
10        
11        for(int i = 0 ; i < n ; i++){
12            for(int j = 0 ; j < i ; j++){
13                if(nums[i] > nums[j]){
14                    up[i] = Math.max(up[i], down[j] + 1);
15                }
16                else if(nums[i] < nums[j]){
17                    down[i] = Math.max(down[i], up[j] + 1);
18                }
19            }
20        }
21
22        int maxValue = 1;
23        for(int i = 0 ; i < n ; i++){
24            maxValue = Math.max(maxValue, Math.max(up[i], down[i]));
25        }
26        return maxValue;
27    }
28}