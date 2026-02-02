1class Solution {
2    public int maxArea(int[] height) {
3
4        int start = 0, end = height.length - 1;
5        long maxWater = 0,  water = 0 ;
6
7        while(start < end){
8            maxWater = Math.max(maxWater, (end - start) * Math.min(height[start], height[end]) );
9
10            if(height[start] < height[end]){
11                start++;
12            }else {
13                end--;
14            }
15        }
16        return (int)maxWater;
17        
18    }
19}