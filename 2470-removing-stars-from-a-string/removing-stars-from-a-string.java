class Solution {
    public String removeStars(String s) {

        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);

            if(c != '*'){
                st.push(c);
                continue;
            }
            if(!st.isEmpty()){
                st.pop();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(!st.isEmpty()){
            char c = st.pop();
            stringBuilder.append(c);
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}