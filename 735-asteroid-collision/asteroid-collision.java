class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for(int end = 0 ; end < n ; end++){
            if(asteroids[end] > 0){
                st.push(asteroids[end]);
                continue;
            }

            if(st.isEmpty() || st.peek() < 0){
                st.push(asteroids[end]);
                continue;
            }

            boolean rem = true;
            while(!st.isEmpty()){
                if(st.peek() < 0){
                    rem = true;
                    break;
                }
                else if(st.peek() < Math.abs(asteroids[end])){
                    st.pop(); rem = true;
                }
                else if(st.peek() == Math.abs(asteroids[end])){
                    st.pop();rem = false; break;
                }else{
                    rem = false;
                    break;
                }
            }

            if(rem){
                st.push(asteroids[end]);
                continue;
            }
        }

        // System.out.println("st : " + st);

        int m = st.size();
        int[] ans = new int[m];
        int index = m -1;
        while(!st.isEmpty()){
            ans[index] = st.pop();
            index--;
        }
        return ans;
    }
}