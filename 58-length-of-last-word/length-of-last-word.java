class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        String lastWord = "";
        char lastChar = ' ';
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            if (currentChar != ' ' && lastChar == ' ') {
                lastWord = "";
                lastWord += currentChar;
            } else if (currentChar != ' ') {
                lastWord += currentChar;
            }
            lastChar = currentChar;

        }
        return lastWord.length();
        
    }
}