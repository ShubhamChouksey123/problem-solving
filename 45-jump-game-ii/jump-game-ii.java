class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }


        int[] minJumps = new int[n];
        for (int i = 1; i < n; i++) {
            minJumps[i] = Integer.MAX_VALUE;
        }
        minJumps[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                minJumps[i + j] = Math.min(minJumps[i + j], minJumps[i] + 1);
            }
        }

        System.out.println("minJumps : " + minJumps[n - 1]);
        return minJumps[n - 1];
        
    }
}