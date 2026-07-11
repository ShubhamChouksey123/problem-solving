class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        Arrays.fill(ans, 0);

        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i] ){
                int index = stack.pollLast();
                ans[index] = (i - index);
            }
            stack.offerLast(i);
        }

        return ans;
    }
}