class Solution {

    public String getShortestWord(String[] strs) {

        String minLengthWord = strs[0];
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLengthWord = strs[i];
                minLength = strs[i].length();
            }
        }
        return minLengthWord;

    }

    public String longestCommonPrefix(String[] strs) {

        String longestCommonPrefix = "";

        String minLengthWord = getShortestWord(strs);
        int minCommonLength = minLengthWord.length();

        for (String word : strs) {
            int currentCommonLength = 0;
            for (int i = 0; i < minLengthWord.length(); i++) {
                if (word.charAt(i) != minLengthWord.charAt(i)) {
                    minCommonLength = Math.min(minCommonLength, currentCommonLength);
                    break;
                }
                currentCommonLength++;
            }
        }

        return minLengthWord.substring(0, minCommonLength);
        
    }
}