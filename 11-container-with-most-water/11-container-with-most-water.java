class Solution {
    
    
    public int maxArea(int[] height) {
        
        int n = height.length;
        Integer maxWater = 0;
        
        Integer start = 0, end = n-1;
        
        while(start < end){
            Integer water = Math.min(height[start], height[end]) * (end-start);
            maxWater = Math.max(maxWater, water);
            
            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
            
            
        }
        
        return maxWater;
        
    }
}