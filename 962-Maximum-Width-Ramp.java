class Solution {
    public int maxWidthRamp(int[] nums) {


        int n = nums.length;
        Deque<int[]> stack = new ArrayDeque<>();
        
        for(int i = 0 ; i < n ; i++){
            if(stack.isEmpty() || stack.peekLast()[0] > nums[i]){
                stack.offerLast(new int[]{nums[i], i});
            }
        }
       

        int maxWidthRamp = 0;
        for(int i = n - 1 ; i > 0 ; i--){

            while(!stack.isEmpty() && stack.peekLast()[1] >= i ){
                stack.pollLast();
            } 

            while(!stack.isEmpty() && stack.peekLast()[1] < i && stack.peekLast()[0] <= nums[i] ){
                int ramp = i - stack.pollLast()[1];
                maxWidthRamp = Math.max(maxWidthRamp, ramp);
            } 
        }
          
        
        return maxWidthRamp;
    }
}