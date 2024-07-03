class Solution {
    public int longestOnes(int[] nums, int k) {

        int n = nums.length, start = 0, countZeros = 0, countOnes = 0, maxCount = 0;

        for(int end = 0 ; end < n ; end++){
            if(nums[end] == 1){
                countOnes++;
            }else {
                countZeros++;
            }
            while(countZeros > k){
                if(nums[start] == 1){
                    countOnes--;
                }else {
                    countZeros--;
                }
                start++;
            }

            maxCount = Math.max(maxCount, countOnes+countZeros);
        }

        return maxCount;
        
    }
}