1class Solution {
2    public int[] maxSlidingWindow(int[] nums, int k) {
3        Deque<Integer> dq = new ArrayDeque<>();
4        int n = nums.length;
5        int[] result = new int[n - k + 1];
6
7        
8        for(int i = 0 ; i < n ; i++){
9
10            if(!dq.isEmpty() && dq.peekFirst() <= i - k){
11                dq.pollFirst();
12            }
13            int cur = nums[i];
14            
15            while(!dq.isEmpty() && cur > nums[dq.peekLast()]){
16                dq.pollLast();
17            }
18
19            dq.offerLast(i);
20            
21            if(i + 1 >= k){
22                result[i-k+1] = nums[dq.peekFirst()];
23            }
24        }
25
26        return result;
27    }
28}