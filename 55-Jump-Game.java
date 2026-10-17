class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length;
        boolean[] isPossible = new boolean[n];
        isPossible[0] = true;
        
        for(int i = 0 ; i < n ; i++){
            if(!isPossible[i]) return false;
            int jump = nums[i];

            for(int j = i + 1 ; j <= i + jump && j < n ; j++) isPossible[j] = true;
        }
        return isPossible[n-1];
    }
}