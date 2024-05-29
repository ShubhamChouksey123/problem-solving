class Solution {
    

    private boolean isEven(String s) {
        char c = s.charAt(s.length() - 1);
        if (c == '1')
            return false;
        return true;
    }


    private String performEvenOperation(String s) {
        return s.substring(0, s.length() - 1);
    }

    private String performOddOperation(String s) {
        StringBuilder str = new StringBuilder(s);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '0') {
                str.setCharAt(i, '1');
                break;
            }
            str.setCharAt(i, '0');
        }
        if (str.charAt(0) == '0') {
            return "1" + str.toString();
        }
        return str.toString();
    }

    public int numSteps(String s) {

        int countOperations = 0;

        while (s.length() > 1) {
            if (isEven(s)) {
                s = performEvenOperation(s);
            } else {
                s = performOddOperation(s);
            }
            countOperations++;
        }
        return countOperations;
    }
}