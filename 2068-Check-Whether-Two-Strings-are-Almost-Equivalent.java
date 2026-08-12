class Solution {

    private static final int TOTAL_CHARS = 26;

    public boolean checkAlmostEquivalent(String word1, String word2) {

        int[] charCountInA = new int[TOTAL_CHARS];
        int[] charCountInB = new int[TOTAL_CHARS];

        for(char c : word1.toCharArray()){
            charCountInA[c - 'a']++;
        }
        for(char c : word2.toCharArray()){
            charCountInB[c - 'a']++;
        }

        for(int i = 0 ; i < TOTAL_CHARS ; i++){
            if(Math.abs(charCountInA[i] - charCountInB[i]) > 3) return false; 
        }
        return true;
    }
}