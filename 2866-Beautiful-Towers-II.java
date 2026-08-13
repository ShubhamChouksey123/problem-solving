class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        
        int n = maxHeights.size();
        long[] left = new long[n];
        long[] right = new long[n];


        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && maxHeights.get(stack.peekLast()) >= maxHeights.get(i)){
                stack.pollLast();
            }

            if(stack.isEmpty()){
                left[i] = (i + 1) * (long)maxHeights.get(i);
            }
            else {
                int topIndex = stack.peekLast();
                left[i] = (i - topIndex) *  (long)maxHeights.get(i) + left[topIndex];
            }
            stack.offerLast(i);
        }
        
        stack.clear();
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && maxHeights.get(stack.peekLast()) >= maxHeights.get(i)){
                stack.pollLast();
            }
            if(stack.isEmpty()){
                right[i] = (n - i) * (long)maxHeights.get(i);
            }
            else {
                int topIndex = stack.peekLast();
                right[i] = (topIndex - i) * (long)maxHeights.get(i) + right[topIndex];
            }
            stack.offerLast(i);
        }
        
        long maxPossibleSum = 0;
        for(int i = 0 ; i < n ; i++){
            long thisSum = left[i] + right[i] - maxHeights.get(i);
            maxPossibleSum = Math.max(maxPossibleSum, thisSum);   
        }

        return maxPossibleSum;
    }
}