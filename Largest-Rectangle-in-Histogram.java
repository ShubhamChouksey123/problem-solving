1class Solution {
2    public int largestRectangleArea(int[] heights) {
3
4        int n = heights.length;
5        int maxArea = 0;
6
7        /**
8            stack containing the valid start element height and its index of rectangle.
9         */
10        Deque<List<Integer>> startElemets = new ArrayDeque<>();
11
12        for(int i = 0 ; i < n ; i++){
13            while(!startElemets.isEmpty() && startElemets.peek().get(0) > heights[i]){
14                List<Integer> startElement = startElemets.pop();
15                int height = startElement.get(0);
16                int width = (!startElemets.isEmpty()) ? (i - startElemets.peek().get(1) - 1) : (i) ; 
17                int curArea = height * width ;
18                maxArea = Math.max(maxArea, curArea);
19            }
20
21            startElemets.push(List.of(heights[i], i));
22        }
23
24        while(!startElemets.isEmpty()){
25            List<Integer> startElement = startElemets.pop();
26            int height = startElement.get(0);
27            int width = (!startElemets.isEmpty()) ? (n - startElemets.peek().get(1) - 1) : (n) ; 
28            int curArea = height * width ;
29            maxArea = Math.max(maxArea, curArea);
30        }
31
32
33        return maxArea;
34    }
35}