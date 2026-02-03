1class Solution {
2    public int trap(int[] height) {
3
4        int n = height.length, start = 0;
5        int end = n-1;
6
7        int maxLeft = 0, maxRight = 0, totalWater = 0;
8
9        while(start <= end){
10            if(height[start] < height[end]){
11                if(height[start] >= maxLeft){
12                    maxLeft = height[start];
13                }else{
14                    int cur = maxLeft - height[start];
15                    totalWater += cur;
16                }
17                start++;
18            }else{
19                if(height[end] >= maxRight){
20                    maxRight = height[end];
21                }else{
22                    int cur = maxRight - height[end];
23                    totalWater += cur;
24                }
25                end--;
26            }
27        } 
28        return totalWater;
29        
30    }
31}