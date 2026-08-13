class Solution {
    public long maximumSumOfHeights(int[] heights) {

        int n = heights.length;

        long maxPossibleSum = 0, thisShapeSum = 0;
        for(int peakIndex = 0 ; peakIndex < n ; peakIndex++){
            thisShapeSum = heights[peakIndex];
            int height = heights[peakIndex];
            for(int i = peakIndex - 1 ; i >= 0 ; i--){
                thisShapeSum += Math.min(heights[i], height);
                height = Math.min(heights[i], height);   
            }
            height = heights[peakIndex];
            for(int i = peakIndex + 1 ; i < n ; i++){
                thisShapeSum += Math.min(heights[i], height);
                height = Math.min(heights[i], height);   
            }
            maxPossibleSum = Math.max(maxPossibleSum, thisShapeSum);
        }
        return maxPossibleSum;

    }

}