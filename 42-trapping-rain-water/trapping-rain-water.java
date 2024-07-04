class Solution {
    public int trap(int[] height) {

        int n = height.length;
        if(n < 2){
            return 0;
        }
        
        int leftElementMax = height[0], rightElementMax = height[n-1], left = 0, right = n-1 ;
        int water = 0, totalWater = 0;

        while(left < right){
            if(leftElementMax <= rightElementMax){
                left++;
                leftElementMax = Math.max(leftElementMax, height[left]);
                water = Math.min(leftElementMax, rightElementMax) - height[left];
            }
            else if(leftElementMax > rightElementMax){
                right--;
                rightElementMax = Math.max(rightElementMax, height[right]);
                water = Math.min(leftElementMax, rightElementMax) - height[right];
            }

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