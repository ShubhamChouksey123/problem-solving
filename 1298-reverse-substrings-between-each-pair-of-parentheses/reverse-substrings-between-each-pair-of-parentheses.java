class Solution {

    public String reverseParentheses(String s) {

        int n = s.length();
        Stack<Character> st = new Stack<>();
        
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            if( c == ')' ){
                List<Character> chars = new ArrayList<>();
                while(!st.isEmpty()){
                    Character top = st.pop();
                    char topChar = top;
                    if(Objects.equals(topChar, '(')){
                        break;
                    } 
                    chars.add(top);
                }
                for(Character ch : chars){
                    st.add(ch);
                }

            }
            else {
                st.add(c);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(!st.isEmpty()){
            stringBuilder.append(st.pop());
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}


/**

"(abcd)"
"(u(love)i)"
"(ed(et(oc))el)"
"abcd"
"(())"
 */