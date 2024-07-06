class Solution {


    public boolean canPartitionUtil(int[] nums, int half, int sumA, int index) {
        
        if(index == nums.length){
            if(sumA == half){
                return true;
            }
            return false;
        }

        return canPartitionUtil(nums, half, sumA, index+1) || 
            canPartitionUtil(nums, half, sumA + nums[index], index+1)  ;


    }

    public int canPartitionUtil(int[] nums, int half, int sumA, int index, int[][] dp) {
        
        // System.out.println("utils for sumA : " + sumA + " and index : " + index );
        
        if(sumA == half){
            return 1;
        }        
        if(index == nums.length){
            return 0;
        }
        if(dp[index][sumA] != -1){
            return dp[index][sumA];
        }
        

        dp[index][sumA] = 0;
        int a = canPartitionUtil(nums, half, sumA, index+1, dp);
        int b = canPartitionUtil(nums, half, sumA + nums[index], index+1, dp);
        if(a == 1 || b == 1){
            dp[index][sumA] = 1;
        }
        // System.out.println("dp[" + index + "][" + sumA + "] : " + dp[index][sumA] );
        return dp[index][sumA];
    }

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int num : nums){
            sum += num; 
        }
        
        if(sum %2 != 0){
            return false;
        }
        // recursive
        // return canPartitionUtil(nums, sum/2, 0, 0);

        int n = nums.length;
        int[][] dp = new int[n][sum+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        int ans = canPartitionUtil(nums, sum/2, 0, 0, dp);

        // System.out.println("dp : " + Arrays.deepToString(dp));
        if(ans == 1)
            return true;
        return false;
    }
}