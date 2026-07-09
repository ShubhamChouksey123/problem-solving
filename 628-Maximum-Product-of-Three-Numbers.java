class Solution {
    public int maximumProduct(int[] nums) {
        // a >= b >= c
        int a = Integer.MIN_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] > a){
                c = b;
                b = a;
                a = nums[i];
            }
            else if(nums[i] > b){
                c = b;
                b = nums[i];
            }
            else if(nums[i] > c){
                c = nums[i];
            }
        }

        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        // x < y
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < x){
                y = x;
                x = nums[i];
            }
            else if(nums[i] < y){
                y = nums[i];
            }
        }
        return Math.max(a * b * c, x * y * a);
    }
}