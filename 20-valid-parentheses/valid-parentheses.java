class Solution {
    private boolean isValidClosing(char openingBracket, char closingBracket) {

        if (openingBracket == '(' && closingBracket == ')')
            return true;
        if (openingBracket == '{' && closingBracket == '}')
            return true;
        if (openingBracket == '[' && closingBracket == ']')
            return true;

        return false;
    }

    public boolean isValid(String s) {

        int n = s.length();

        if (n % 2 != 0)
            return false;

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Objects.equals(c, '(') || Objects.equals(c, '{') || Objects.equals(c, '[')) {
                st.push(c);
                continue;
            }

            if (st.isEmpty()) {
                return false;
            }
            char openingBracket = st.pop();

            if (!isValidClosing(openingBracket, c)) {
                return false;
            }
        }
        
        if(st.isEmpty())
            return true;
        
        return false;

    }
}