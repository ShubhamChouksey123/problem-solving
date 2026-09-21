class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int start = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];

        for(int end = 0 ; end < n ; end ++){
            
            start = Math.max(0, end - k + 1);
            // remove elements which are out of start 
            while(!deque.isEmpty() && deque.peekFirst() < start){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[end]){
                deque.pollLast();
            }

            if(deque.isEmpty() || nums[deque.peekLast()] >= nums[end]){
                deque.offerLast(end);   
            }
            ans[start] = nums[deque.peekFirst()];
        }   
        return ans;
    }
}