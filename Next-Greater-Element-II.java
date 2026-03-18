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
11        for(int i = 0 ; i < 2*n ; i++){
12            while(!st.isEmpty() && st.peek()[0] < nums[i % n]){
13                int[] topElement = st.pop();
14                nextGreaterOnRight[topElement[1]] = nums[i % n];
15            }
16            if(i < n){
17                st.push(new int[]{nums[i], i});
18            }
19            
20        }
21        return nextGreaterOnRight;
22    }
23}