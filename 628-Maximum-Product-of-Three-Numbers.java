class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;

        int maxValue = Integer.MIN_VALUE, secondMaxValue = Integer.MIN_VALUE, thirdMaxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE, secondMinValue = Integer.MAX_VALUE;

        for(int num : nums){

            if(num > maxValue){
                thirdMaxValue = secondMaxValue; 
                secondMaxValue = maxValue;
                maxValue = num;
            }
            else if(num > secondMaxValue){
                thirdMaxValue = secondMaxValue; 
                secondMaxValue = num;
            }
            else if(num > thirdMaxValue){
                thirdMaxValue = num; 
            }

            if(num < minValue){
                secondMinValue = minValue;
                minValue = num;
            }
            else if(num < secondMinValue){
                secondMinValue = num;
            }
        }

        return Math.max(maxValue * secondMaxValue * thirdMaxValue, maxValue * minValue * secondMinValue);
    }
}