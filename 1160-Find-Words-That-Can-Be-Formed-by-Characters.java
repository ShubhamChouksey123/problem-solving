class Solution {

    private static final int TOTAL_CHARS = 26;

    private boolean isGood(String word, int[] charCounts){
        int[] wordCounts = new int[26];

        for(char c : word.toCharArray()){
            wordCounts[c - 'a']++;
        }

        for(int i = 0 ; i < TOTAL_CHARS ; i++){
            if(charCounts[i] < wordCounts[i]) return false;
        }
        return true;
    }

    public int countCharacters(String[] words, String chars) {

        int[] charCounts = new int[26];
        for(char c : chars.toCharArray()){
            charCounts[c - 'a']++;
        }

        int length = 0;
        for(int i = 0 ; i < words.length ; i++){
            String word = words[i];
            if(isGood(word, charCounts)){
                length += word.length();
            }
        }   
        return length;
    }
}