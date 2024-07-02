class Solution {
    public int trap(int[] height) {

        int n = height.length;
        if(n < 2){
            return 0;
        }
        
        int[] maxElementRight = new int[n];
        int[] maxElementLeft = new int[n];

        int maxValue = height[0];
        for(int i = 1; i < n ; i++){
            maxElementLeft[i] = maxValue;
            maxValue = Math.max(maxValue, height[i]);
        }

        maxValue = height[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            maxElementRight[i] = maxValue;
            maxValue = Math.max(maxValue, height[i]);
        }

        int totalWater = 0;
        for(int i = 1 ; i < n-1 ; i++){
            int water = Math.min(maxElementLeft[i], maxElementRight[i]) - height[i];
            if(water > 0){
                totalWater += water;
            }
        }

        return totalWater;
    }
}


/**

maximum height on its left
0, 1,0,2,1,0,1,3,2,1,2,1
-1 0,1,1,2,2,2,2,3,3,3,3


maximum height on its right
0, 1,0,2,1,0,1,3,2,1,2,1
..            ..  ,2,1,-1


O(n)
maxHeight Right = 2
maxHeight left = 3
min(2, 3) => 2
water 2 -1 = 1


 */