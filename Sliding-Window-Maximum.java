1class Solution {
2    public int[] maxSlidingWindow(int[] nums, int k) {
3
4        /**
5            Deque containg value and its index {value, index}
6         */
7        Deque<int[]> elements = new ArrayDeque<>();
8        int n = nums.length;
9        int[] maxSlidingValue = new int[n-k+1];
10
11        for(int i = 0 ; i < n ; i++){
12
13            if(!elements.isEmpty() && elements.peekFirst()[1] <= i - k){
14                elements.pollFirst();
15            }
16
17            int cur = nums[i];
18            while(!elements.isEmpty() && elements.peekLast()[0] <= cur){
19                elements.pollLast();
20            }
21            elements.offerLast(new int[]{cur, i});
22            if(i >= k - 1){
23                maxSlidingValue[i-k+1] = elements.peekFirst()[0];
24            }
25        }
26
27        return maxSlidingValue;
28    }
29}