class Solution {

    private int heightHistogram(int[] heights){

        int n = heights.length, maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && heights[stack.peekLast()] > heights[i]){
                int indexAtTop = stack.pollLast();
                int height = heights[indexAtTop];
                int leftBoundry = (!stack.isEmpty()) ? stack.peekLast() + 1 : 0;
                int width = i - leftBoundry;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.offerLast(i);
        }

        while(!stack.isEmpty() ){
            int indexAtTop = stack.pollLast();
            int height = heights[indexAtTop];
            int leftBoundry = (!stack.isEmpty()) ? stack.peekLast() + 1 : 0;
            int width = n - leftBoundry;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length, m = matrix[0].length, maxArea = 0;
        int[][] heights = new int[n][m];

        for(int j = 0 ; j < m ; j++){
            for(int i = 0 ; i < n ; i++){
                if(matrix[i][j] == '0') continue;
                if(i-1 >= 0){
                    heights[i][j] = 1 + heights[i-1][j];   
                }else{
                    heights[i][j] = 1;   
                }
                
            }
        } 

        for(int i = 0 ; i < n ; i++){
            int area = heightHistogram(heights[i]);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
        
    }
}