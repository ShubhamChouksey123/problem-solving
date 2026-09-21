class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length; 
        int[] nextGreaterElement = new int[n];
        Arrays.fill(nextGreaterElement, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int end = 0; end < (2 * n - 1) ; end++){

            int num = nums[end % n];
            while(!stack.isEmpty() && nums[stack.peekLast()] < num){
                int topIndex = stack.pollLast();
                nextGreaterElement[topIndex] = num;
            }
            if(end < n){
                stack.offerLast(end);
            }
                
        }
        return nextGreaterElement;
    }
}