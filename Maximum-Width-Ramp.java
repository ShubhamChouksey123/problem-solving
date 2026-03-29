1class Solution {
2    public int maxWidthRamp(int[] nums) {
3
4        int n = nums.length; 
5        int start = 0;
6        int maxRamp = 0, ramp = 0;
7        int[] greatestOnRight = new int[n];
8        greatestOnRight[n-1] = nums[n-1];
9
10        for(int j = n - 2 ; j >= 0 ; j--){
11            greatestOnRight[j] = Math.max(greatestOnRight[j+1], nums[j]);
12        }
13
14        for(int end = 1 ; end < n ; end++){
15            while(end < n && nums[start] <= greatestOnRight[end]){
16                maxRamp = Math.max(maxRamp, end - start);
17                end++;
18            }
19            if(end < n && nums[start] > greatestOnRight[end]){
20                start++;
21            }
22        }  
23        return maxRamp; 
24        
25    }
26}