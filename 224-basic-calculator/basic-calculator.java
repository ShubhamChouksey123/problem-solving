class Solution {
    
    
    private boolean isDigit(Character c) {

        if (c >= '0' && c <= '9')
            return true;
        return false;
    }

    private void evaluateAndAdd(Stack<String> st) {

        int amount = 0;
        while (!st.isEmpty()) {
            String topElement = st.pop();

            if (Objects.equals(topElement, "(")) {
                if (!st.isEmpty() && Objects.equals(st.peek(), "-")) {
                    amount = amount * -1;
                    st.pop();
                }
                break;
            }
            amount = amount + Integer.parseInt(topElement);
        }
        st.push(String.valueOf(amount));
    }

    private int evaluateSumOfStack(Stack<String> st) {

        int sum = 0;
        while (!st.isEmpty()) {
            String topElement = st.pop();

            if (Objects.equals(topElement, "-")) {
                sum = sum * -1;
            } else {
                sum = sum + Integer.parseInt(topElement);
            }


        }
        return sum;
    }

    private int getNumber(Character startChar, Integer index, Stack<String> st, String s) {

        StringBuilder word = new StringBuilder();
        word.append(startChar);
        while (index + 1 < s.length() && isDigit(s.charAt(index + 1))) {
            index++;
            word.append(s.charAt(index));
        }
        st.push(word.toString());
        return index;
    }

    public int calculate(String s) {
        int n = s.length();
        Stack<String> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            if (Objects.equals(c, '(')) {
                st.push(String.valueOf(c));
            } else if (Objects.equals(c, ')')) {
                evaluateAndAdd(st);
            } else if (Objects.equals(c, '-')) {
                i = getNumber(c, i, st, s);
            } else if (c >= '0' && c <= '9') {
                i = getNumber(c, i, st, s);
            }


        }

        System.out.println("st: " + st);
        return evaluateSumOfStack(st);
    }
}