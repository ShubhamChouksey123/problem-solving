class Solution {
    public int trap(int[] height) {
        int n = height.length;

        if (n == 1 || n == 2)
            return 0;

        int[] maxElementRight = new int[n];
        int[] maxElementLeft = new int[n];

        for (int i = 0; i < n; i++) {
            maxElementLeft[i] = 0;
            maxElementRight[i] = 0;
        }

        maxElementLeft[0] = 0;
        maxElementRight[n - 1] = 0;


        int maxElementLeftValue = height[0];
        for (int i = 1; i < n; i++) {
            maxElementLeft[i] = Math.max(maxElementLeftValue - height[i], 0);
            maxElementLeftValue = Math.max(maxElementLeftValue, height[i]);
        }

        // System.out.println("maxElementLeft : " + Arrays.toString(maxElementLeft));

        int maxElementRightValue = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxElementRight[i] = Math.max(maxElementRightValue - height[i], 0);
            maxElementRightValue = Math.max(maxElementRightValue, height[i]);
        }

        // System.out.println("maxElementRight : " + Arrays.toString(maxElementRight));

        int waterStored = 0;
        for (int i = 1; i < n - 1; i++) {
            waterStored += Math.min(maxElementLeft[i], maxElementRight[i]);
        }

        // System.out.println("waterStored : " + waterStored);
        return waterStored;

        
    }
}