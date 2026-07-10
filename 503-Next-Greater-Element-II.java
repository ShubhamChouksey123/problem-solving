class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < 2 * n ; i++){

            while(!stack.isEmpty() && nums[stack.peekLast()] < nums[i % n]){
                ans[stack.pollLast()] = nums[i % n];
            }
            
            if(i < n){
                stack.offerLast(i);
            }
        }
        return ans;
        
    }
}