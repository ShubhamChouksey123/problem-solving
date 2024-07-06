class Solution {
    
    private int robUtil1(int[] nums, int index) {

        if(index < 0){
            return 0;
        }

        int a = nums[index] + robUtil1(nums, index-2);
        int b = robUtil1(nums, index-1);
        return Math.max(a,b);
        
    }


    private int robUtil(int[] nums, int index, int[] maxAmount){
        // System.out.println("RU index : " + index);
        if(index < 0){
            return 0;
        }
        if(maxAmount[index] != -1){
            return maxAmount[index];
        }

        int a = nums[index] + robUtil(nums, index-2, maxAmount);
        int b = robUtil(nums, index-1, maxAmount);
        maxAmount[index] = Math.max(a, b);

        // System.out.println("maxAmount [" + index + "] : " + maxAmount[index] );
        return maxAmount[index];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        // recursive
        // return robUtil1(nums, n-1);

        if(nums.length == 1){
            return nums[0];
        }

        int[] maxAmount = new int[n];
        Arrays.fill(maxAmount, -1);
        maxAmount[0] = nums[0];

        robUtil(nums, n-1, maxAmount);
        return maxAmount[n-1];

    }
}