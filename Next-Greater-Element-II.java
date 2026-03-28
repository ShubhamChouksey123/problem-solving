1class Solution {
2    public int[] nextGreaterElements(int[] nums) {
3        
4        Deque<Integer> st = new ArrayDeque<Integer>();
5        int n = nums.length;
6        int[] nextGreaterElement = new int[n];
7        Arrays.fill(nextGreaterElement, -1);
8
9        for(int i = 0 ; i < (2 * n) ; i++){
10
11            while(!st.isEmpty() && nums[st.peek()] < nums[i % n]){
12                nextGreaterElement[st.pop()] = nums[i % n];
13            }
14
15            if(i < n){
16                st.push(i);
17            }    
18            
19        }
20        return nextGreaterElement;
21    }
22}