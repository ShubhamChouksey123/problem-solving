class Solution {

    private String appendReverseString(String reverseWord, String word) {

        if (reverseWord.length() == 0) {
            reverseWord = word + reverseWord;
            return reverseWord;
        }

        return word +  " " + reverseWord;
    }
    public String reverseWords(String s) {

        String reverseWord = "";
        String lastWord = "";

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == ' ') {
                if (lastWord.length() > 0) {
                    reverseWord = appendReverseString(reverseWord, lastWord);
                    lastWord = "";
                }
            } else {
                lastWord += currentChar;
            }
        }

        if(lastWord.length() > 0){
            reverseWord = appendReverseString(reverseWord, lastWord);
        }

        return reverseWord;
        
    }
}