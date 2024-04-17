class Solution {
    public int trap(int[] height) {
        int n = height.length;

        if (n == 1 || n == 2)
            return 0;


        int totalWaterStored = 0;
        int currentWaterStored = 0;

        int maxElementLeftValue = height[0];
        int maxElementRightValue = height[n - 1];

        int leftPointer = 0;
        int rightPointer = n - 1;

        while (leftPointer < rightPointer) {

            if (maxElementLeftValue <= maxElementRightValue) {
                leftPointer++;
                currentWaterStored = Math.max(maxElementLeftValue - height[leftPointer], 0);
                maxElementLeftValue = Math.max(maxElementLeftValue, height[leftPointer]);
                

            } else {
                rightPointer--;
                currentWaterStored = Math.max(maxElementRightValue - height[rightPointer], 0);
                maxElementRightValue = Math.max(maxElementRightValue, height[rightPointer]);
               
            }

            totalWaterStored += currentWaterStored;
        }


        // System.out.println("totalWaterStored : " + totalWaterStored);

        return totalWaterStored;

        
    }
}