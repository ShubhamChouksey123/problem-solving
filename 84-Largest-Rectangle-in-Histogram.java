class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length, maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && heights[stack.peekLast()] > heights[i]){
                int indexAtTop = stack.pollLast();
                int leftIndex = (!stack.isEmpty()) ? stack.peekLast() : -1;
                int width = i - leftIndex - 1;
                int area = heights[indexAtTop] * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.offerLast(i);
        }

        while(!stack.isEmpty()){
            int indexAtTop = stack.pollLast();
            int leftIndex = (!stack.isEmpty()) ? stack.peekLast() : -1;
            int width = n - leftIndex - 1;
            int area = heights[indexAtTop] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}