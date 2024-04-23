class Solution {
    
    private boolean isDigit(Character c) {
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }
    
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();

        int number = 0;
        int result = 0;
        int sign = 1;

        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            if (Objects.equals(c, ' ')) {
                continue;
            }

            if (Objects.equals(c, '(')) {
                st.push(result);
                st.push(sign);
                number = 0;
                result = 0;
                sign = 1;
            } else if (Objects.equals(c, ')')) {
                result = result + (number * sign);
                number = 0;
                sign = st.pop();
                result = result * sign;
                result = st.pop() + result;
            } else if (Objects.equals(c, '+')) {
                result = result + (number * sign);
                number = 0;
                sign = 1;
            } else if (Objects.equals(c, '-')) {
                result = result + (number * sign);
                number = 0;
                sign = -1;
            } else if (isDigit(c)) {
                number = number * 10 + c - '0';
            }


        }

        if (number != 0) {
            result = result + (number * sign);
        }

        System.out.println("st: " + st);
        return result;
    }
}