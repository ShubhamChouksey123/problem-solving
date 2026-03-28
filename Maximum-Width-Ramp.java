1class Solution {
2    public int maxWidthRamp(int[] nums) {
3
4        int n = nums.length;
5        int[] greatestOnRight = new int[n];
6        greatestOnRight[n-1] = nums[n-1];
7
8        int maxvalue = Integer.MIN_VALUE;
9        for(int i = n - 2 ; i >= 0 ; i--){
10            greatestOnRight[i] = Math.max(greatestOnRight[i+1], nums[i]);
11        }
12
13        int start = 0;
14        int maxRamp = 0;
15        for(int end = 1 ; end < n ; end++){
16            if(nums[start] <= nums[end]){
17                maxRamp = Math.max(maxRamp, end - start);
18            }
19            else if(nums[start] > greatestOnRight[end]){
20                start++;
21            }
22        }
23        
24        return maxRamp;
25    }
26}