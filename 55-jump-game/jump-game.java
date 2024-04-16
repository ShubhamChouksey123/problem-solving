class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }


        boolean[] canReach = new boolean[n];
        canReach[0] = true;

        for (int i = 0; i < n; i++) {
            if (!canReach[i]) {
                return false;

            }
            for (int j = 0; j <= nums[i] && i + j < n; j++) {
                canReach[i + j] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!canReach[i])
                return false;
        }

        System.out.println("canReach : " + true);
        return canReach[n-1];
    }
}