class Solution {
    public int maxArea(int[] height) {
        
        int maxWater = 0;
        int start = 0, end = height.length - 1;

        while(start < end){
            int water = (end - start) * Math.min(height[start], height[end]);
            maxWater = Math.max(maxWater, water);

            if(height[start] < height[end]){
                start++;
            }else {
                end--;
            }
        }
        return maxWater;
    }
}