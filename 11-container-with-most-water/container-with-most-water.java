class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int startIndex = 0;
        int endIndex = n - 1;

        int maxWater = Integer.MIN_VALUE;

        while (startIndex < endIndex) {

            int water = (endIndex - startIndex) * Math.min(height[startIndex], height[endIndex]);
            maxWater = Math.max(water, maxWater);

            if (height[startIndex] < height[endIndex]) {
                startIndex++;
            } else {
                endIndex--;
            }
        }

        return maxWater;
    }
}