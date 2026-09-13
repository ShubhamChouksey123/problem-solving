class Solution {
    public int maxProduct(int[] nums) {

        int minSoFar = nums[0], maxSoFar = nums[0];
        int n = nums.length;
        int maxProduct = maxSoFar;

        for(int i = 1 ; i < n ; i++){
            int num = nums[i];
            int newMinSoFar = Math.min(Math.min(minSoFar * num, maxSoFar * num), num);
            int newMaxSoFar = Math.max(Math.max(minSoFar * num, maxSoFar * num), num);
            maxSoFar = newMaxSoFar; minSoFar = newMinSoFar;
            maxProduct = Math.max(maxProduct, maxSoFar);
        }

        return maxProduct;
    }
}