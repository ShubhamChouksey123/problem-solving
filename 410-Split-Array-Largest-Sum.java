class Solution {

    private int binarySeacrh(int[] nums, int k, int minRange, int maxRange) {
        
        if(minRange == maxRange){
            return minRange;
        }
        
        int midRange = minRange + (maxRange - minRange)/2;

        if(canSplit(nums, k, midRange)){
            return binarySeacrh(nums, k, minRange, midRange);
        }
        else{
            return binarySeacrh(nums, k, midRange + 1, maxRange);
        }
    }

    private boolean canSplit(int[] nums, int k, int maxValue){

        int start = 0, n = nums.length;
        int splits = 0;
        while(start < n){
            int end = start;
            int sum = nums[end];
            while(end + 1 < n &&  sum + nums[end + 1] <= maxValue){
                end = end + 1;
                sum += nums[end];
            } 
            splits++;
            start = end + 1;
        }
        return splits <= k;
    }

    public int splitArray(int[] nums, int k) {
        int maxValue = nums[0];
        int totalSum = 0;

        for(int num : nums){
            maxValue = Math.max(maxValue, num);
            totalSum += num;
        } 

        return binarySeacrh(nums, k, maxValue, totalSum);
    }
}