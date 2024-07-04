class Solution {
    public boolean canJump(int[] nums) {

        int  n = nums.length;
        boolean[] canReach = new boolean[n];
        canReach[0] = true;

        for(int i = 0; i < n ; i++){
            if(canReach[i] == true){
                for(int j = i+1 ; j <= i + nums[i] && j < n; j++){
                    canReach[j] = true;
                }
            }
        }       

        return canReach[n-1];
    }
}