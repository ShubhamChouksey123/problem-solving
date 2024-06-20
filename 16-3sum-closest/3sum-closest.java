class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int absClosestSum = Integer.MAX_VALUE, n = nums.length;
        int sumClosestSum = 0;
        Arrays.sort(nums);

        int left = 1, right = n-1;
        for(int i = 0; i < n -2 ; i++){
            int rem = target - nums[i];
            left = i+1; 
            right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(absClosestSum > Math.abs(target - sum)){
                    sumClosestSum = sum;
                    absClosestSum = Math.abs(target - sum);
                }

                if(sum == target){
                    break;
                }
                else if(sum < target){
                    left++;
                }else{
                    right--;
                }

            }
        }
        return sumClosestSum;
        
    }
}