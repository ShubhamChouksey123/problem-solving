class Solution {

    private int totalCount = 0;

    public void combinationSum4Util(int[] nums, int target, int sum) {
        
        if(sum == target){
            totalCount++;
        }
        if(sum > target){
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            combinationSum4Util(nums, target, sum + nums[i]);
        }
    }

    public int combinationSum4Utility(int[] nums, int target, int[] countWays) {
        
        if(target < 0){
            return 0;
        }
        if(target == 0){
            return 1;
        }

        if(countWays[target] != -1){
            return countWays[target];
        }

        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] <= target){
                count += combinationSum4Utility(nums, target - nums[i], countWays); 
            }
        }
        countWays[target] = count;
        return countWays[target];
    }

    public int combinationSum4(int[] nums, int target) {
        // totalCount = 0;
        // Arrays.sort(nums);
        // combinationSum4Util(nums, target, 0);
        // return totalCount;

        totalCount = 0;
        Arrays.sort(nums);

        int[] countWays = new int[target+1];
        Arrays.fill(countWays, -1);
        return combinationSum4Utility(nums, target, countWays);
        // return totalCount;

    }
}