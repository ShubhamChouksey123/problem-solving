class Solution {

    private int findGreaterOrEqual(int[] nums, int value, int start, int end){
        
        int ans = -1;
        while(start <= end){
            int mid = (end - start)/2 + start;
            if(nums[mid] >= value){
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    } 

    private int findLessOrEquals(int[] nums, int value, int start, int end){
        
        int ans = -1;
        while(start <= end){
            int mid = (end - start)/2 + start;
            if(nums[mid] <= value){
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    } 

    public int waysToSplit(int[] nums) {
        
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i = 1 ; i < n ; i++){
            sum[i] = nums[i] + sum[i-1];
        } 
        

        int left = 0, mid = 0, end = 0;
        long count = 0;
        long MOD = 1_000_000_000 + 7;
        for(int i = 0 ; i < n - 2 ; i++){
            left = sum[i];
            int minIndex = findGreaterOrEqual(sum, 2 * left, i + 1, n - 2); 
            
            int findValue = (sum[n-1] - left)/2 + left;
            int maxIndex = findLessOrEquals(sum, findValue, i + 1, n - 2);  

            if(minIndex != -1 && maxIndex != -1 && minIndex <= maxIndex){
                count = (count + (maxIndex - minIndex + 1)) % MOD;
            }
            
        }
        return (int)count;
    }
}