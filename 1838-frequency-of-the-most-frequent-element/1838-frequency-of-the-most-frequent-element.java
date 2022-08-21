class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int maxFrequency = 1;
        
        int left = 0; int right = 1;
        int curSum = 0;
        while(right < n){
            int localMaxFrequent = nums[right];
            
            curSum = curSum + (localMaxFrequent - nums[right-1])*(right - left);
            
            if(curSum > k){
                curSum = curSum - (nums[right] - nums[left]);
                left++;
            }
            int localMaxFrequncy = right - left + 1;
            maxFrequency = Math.max(maxFrequency, localMaxFrequncy);
            right++;
        }
        return maxFrequency;
        
    }
}
/**
[1,2,4]
5
[1,4,8,13]
5
[3, 9, 6]
2
*/