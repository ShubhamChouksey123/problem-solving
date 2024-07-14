class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        // Integer[] a a[0] => value, a[1] => index
        Stack<Integer[]> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for(int i = 0 ; i < n ; i++){

            int temperature = temperatures[i];
            if(st.isEmpty()){
                st.add(new Integer[]{temperature, i});
                continue;
            }
            while(!st.isEmpty() && st.peek()[0] < temperature){
                Integer[] top = st.pop();
                ans[top[1]] = i - top[1];
            }
            st.add(new Integer[]{temperature, i});
        }

        return ans;
        
    }
}