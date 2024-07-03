class Solution {
    public int longestSubarray(int[] nums) {

        int n = nums.length, countOnes = 0, countZeros = 0, start = 0, maxLength = 0;

        for(int num : nums){
            if(num == 1){
                countOnes++;
            }
        }
        if(countOnes == n){
            return n-1;
        }

        countOnes = 0;
        for(int end = 0 ; end < n ; end++){
            if(nums[end] == 1){countOnes++;} else {countZeros++;}

            while(countZeros > 1){
                if(nums[start] == 1){countOnes--;} else {countZeros--;}
                start++;
            }
            maxLength = Math.max(maxLength, countZeros + countOnes-1);
        }
        return maxLength;
    }
}