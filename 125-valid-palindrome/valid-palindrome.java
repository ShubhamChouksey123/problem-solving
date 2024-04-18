class Solution {

    private String preProcessString(String s) {
        int n = s.length();
        s = s.toLowerCase();
        StringBuilder processedString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Character c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                processedString.append(c);
            }
            else if (c >= '0' && c <= '9') {
                processedString.append(c);
            }
        }
        return processedString.toString();
    }

    public boolean isPalindrome(String s) {
        s = preProcessString(s);
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}