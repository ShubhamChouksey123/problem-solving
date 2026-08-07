class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        
        int n = heights.length;
        int[] answer = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = n - 1; i >= 0 ; i--){
            
            while(!stack.isEmpty() && stack.peekLast() <= heights[i]){
                stack.pollLast();
                answer[i]++;
            }  
            if(!stack.isEmpty()){
                answer[i]++;
            }
            stack.offerLast(heights[i]); 
        } 
        return answer;
    }
}