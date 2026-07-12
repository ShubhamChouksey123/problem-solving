class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // stack containing {height, index}
        Deque<int[]> stack = new ArrayDeque<>();
        int maxArea = 0;

        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && stack.peekLast()[0] > heights[i]){
                int[] topElement = stack.pollLast();
                int height = topElement[0];
                int startOfThisBlock = (stack.isEmpty()) ? 0 : stack.peekLast()[1] + 1;
                int width = (i - startOfThisBlock);
                maxArea = Math.max(maxArea, height * width);
            }
            stack.offerLast(new int[]{heights[i], i});
        }
        

        while(!stack.isEmpty()){
            int[] topElement = stack.pollLast();
            int height = topElement[0];
            int startOfThisBlock = (stack.isEmpty()) ? 0 : stack.peekLast()[1] + 1;
            int width = (n - startOfThisBlock);
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}