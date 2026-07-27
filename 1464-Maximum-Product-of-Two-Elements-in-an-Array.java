class Solution {
    public int maxProduct(int[] nums) {

        int maxValue = 0, secondMaxValue = 0;

        for(int num : nums){
            if(num > maxValue){
                secondMaxValue = maxValue;
                maxValue = num;
            }
            else if(num > secondMaxValue){
                secondMaxValue = num;
            }
        }
        return (maxValue - 1) * (secondMaxValue - 1);
    }
}