class Solution {
    
    private int totalSum = 0;
    private void subsetXORSumUtil(int[] nums, int n, int index, int sum) {

        if (index == n) {
            totalSum += sum;
            return;
        }

        subsetXORSumUtil(nums, n, index + 1, sum);
        subsetXORSumUtil(nums, n, index + 1, sum ^ nums[index]);

    }

    public int subsetXORSum(int[] nums) {

        subsetXORSumUtil(nums, nums.length, 0, 0);
        return totalSum;
    }

}