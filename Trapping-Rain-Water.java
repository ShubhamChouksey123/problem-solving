1class Solution {
2
3    private void populate(int[] height, int[] maxHeightLeft, int[] maxHeightRight) {
4
5        int n = height.length ;
6        int maxLeft = height[0];
7        for(int i = 1 ; i <= n - 1 ; i++){
8            maxHeightLeft[i] = maxLeft;
9            maxLeft = Math.max(maxLeft, height[i]);
10        }
11
12        int maxRight = height[n-1];
13        for(int i = n-2 ; i >= 0 ; i--){
14            maxHeightRight[i] = maxRight;
15            maxRight = Math.max(maxRight, height[i]);
16        }
17    
18    }
19
20    public int trap(int[] height) {
21
22        int n = height.length ;
23        int[] maxHeightLeft = new int[n];
24        int[] maxHeightRight = new int[n];
25
26        populate(height, maxHeightLeft, maxHeightRight) ;
27        int water = 0;
28
29        for(int i = 1 ; i <= n-2 ; i++){
30            int curWater = Math.min(maxHeightLeft[i], maxHeightRight[i]) - height[i];
31            water += Math.max(0,  curWater);
32        }
33
34        return water;
35        
36    }
37}