1class Solution {
2    public int[] nextGreaterElements(int[] nums) {
3        int n = nums.length;
4        /**
5        * stack containing num[i] and i => value and index
6         */
7        Stack<int[]> st = new Stack<>();
8        int[] nextGreaterOnRight = new int[n];
9        Arrays.fill(nextGreaterOnRight, -1);
10        
11        for(int i = 0 ; i < n ; i++){
12            while(!st.isEmpty() && st.peek()[0] < nums[i]){
13                int[] topElement = st.pop();
14                nextGreaterOnRight[topElement[1]] = nums[i];
15            }
16            st.push(new int[]{nums[i], i});
17        }
18
19        for(int i = 0 ; i < n - 1 ; i++){
20            while(!st.isEmpty() && st.peek()[0] < nums[i]){
21                int[] topElement = st.pop();
22                nextGreaterOnRight[topElement[1]] = nums[i];
23            }
24            st.push(new int[]{nums[i], i});
25        }
26        
27        return nextGreaterOnRight;
28    }
29}