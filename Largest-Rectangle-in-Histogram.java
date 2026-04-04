1class Solution {
2    public int largestRectangleArea(int[] heights) {
3
4        int n = heights.length;
5        int area = heights[0], maxArea = heights[0];
6        Deque<Integer> increasingHeights = new ArrayDeque<>();
7
8        for(int i = 0 ; i < n ; i++){
9            
10            while(!increasingHeights.isEmpty() && heights[increasingHeights.peek()] > heights[i]){
11                int height = heights[increasingHeights.poll()];
12                int width = (increasingHeights.isEmpty()) ? i : i - increasingHeights.peek() - 1;
13                maxArea = Math.max(maxArea, height * width);
14            }   
15            increasingHeights.push(i);
16        }
17
18        while(!increasingHeights.isEmpty()){
19            int height = heights[increasingHeights.poll()];
20            int width = (increasingHeights.isEmpty()) ? n : n - increasingHeights.peek() - 1;
21            maxArea = Math.max(maxArea, height * width);
22        }
23
24        return maxArea;
25    }
26}