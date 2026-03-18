1class Solution {
2    public int[] dailyTemperatures(int[] temperatures) {
3
4        int n = temperatures.length;
5        int[] ans = new int[n];
6
7        /**
8        *   stack containing the indexes of the temperatues 
9         */
10        Stack<Integer> st = new Stack<>();
11
12        for(int i = 0 ; i < n ; i++){
13            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
14                int indexOfTemp = st.pop();
15                ans[indexOfTemp] = i - indexOfTemp;
16            }
17            st.push(i);
18        }
19
20        return ans;
21    }
22}