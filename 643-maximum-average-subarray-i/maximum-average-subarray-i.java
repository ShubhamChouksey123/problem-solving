class Solution {


    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0, avg = 0.0;
        for(int i = 0 ; i < k; i++){
            sum += nums[i]; 
        }
        avg = sum/k;

        for(int end = k  ; end < n ; end++){
            sum += nums[end];
            sum -= nums[end-k];
            avg = Math.max(avg, sum/k);
        }    

        return avg;
    }
}