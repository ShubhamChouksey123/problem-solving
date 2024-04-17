class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prodArray = new int[nums.length];

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            prodArray[i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            prodArray[i] = prodArray[i + 1] * nums[i + 1];
        }

        int prodLeft = 1;

        for (int i = 0; i < n; i++) {
            prodArray[i] = prodArray[i] * prodLeft;
            prodLeft *= nums[i];
        }

        // System.out.println("prodArray : " + Arrays.toString(prodArray));
        return prodArray;
    }
}