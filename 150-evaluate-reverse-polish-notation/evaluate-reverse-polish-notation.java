class Solution {

    private void performOperation(String operation, Stack<Integer> st) {

        Integer secondValue = st.pop();
        Integer firstValue = st.pop();

        Integer result = null;
        if (Objects.equals(operation, "+")) {
            result = firstValue + secondValue;
        } else if (Objects.equals(operation, "-")) {
            result = firstValue - secondValue;
        } else if (Objects.equals(operation, "*")) {
            result = firstValue * secondValue;
        } else {
            result = firstValue / secondValue;
        }
        st.push(result);

    }
    public int evalRPN(String[] tokens) {

        int n = tokens.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            String s = tokens[i];

            if (Objects.equals(s, "+") || Objects.equals(s, "-") || Objects.equals(s, "*") || Objects.equals(s, "/")) {
                performOperation(s, st);
            } else {
                Integer intVal = Integer.valueOf(s);
                st.push(intVal);
            }
        }

        return st.pop();
        
    }
}