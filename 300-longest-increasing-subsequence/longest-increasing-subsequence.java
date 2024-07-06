class Solution {
    
    private int maxValue = 1;

    public int lengthOfLIS1(int[] nums, int index) {
        
        System.out.println("LIS1 for index : " + index );
        if(index == 0){
            return 1;
        }

        int maxLength = 1;
        for(int i = index - 1 ; i >= 0 ; i--){
            if(nums[i] < nums[index]){
                int length = lengthOfLIS1(nums, i) + 1; 
                maxLength = Math.max(length, maxLength);
                maxValue = Math.max(maxValue, maxLength);
            }
        }
        System.out.println("LIS1 for index : " + index + " maxLength : " + maxLength);
        return maxLength;
    }

    public int lengthOfLIS(int[] nums, int index, int[] longestSeqLength) {
        
        // System.out.println("LIS for index : " + index );
        if(index == 0){
            return 1;
        }

        if(longestSeqLength[index] != -1){
            return longestSeqLength[index];
        }

        int maxLength = 1;
        for(int i = index - 1 ; i >= 0 ; i--){
            if(nums[i] < nums[index]){
                int length = lengthOfLIS(nums, i, longestSeqLength) + 1; 
                maxLength = Math.max(length, maxLength);
                maxValue = Math.max(maxValue, maxLength);
            }
        }

        longestSeqLength[index] = maxLength;
        // System.out.println("longestSeqLength[" + index + "] : " + longestSeqLength[index]);
        return maxLength;
    }
    
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        // recursive
        // for(int i = 1 ; i < n ; i++){
        //     lengthOfLIS1(nums, i);
        // }
        // return maxValue; 



        int[] longestSeqLength = new int[n];
        Arrays.fill(longestSeqLength, -1);


        for(int i = 1; i < n ; i++){
            lengthOfLIS(nums, i, longestSeqLength);
        }
        
        return maxValue;
    }
}