class Solution {
    
    private int maxScore = 0;

    private void createWordCount(char[] letters, int[] counts) {
        for(char c : letters){
            counts[c - 'a']++;
        }
    }

    private boolean isPossible(String word, int[] counts){

        int[] charCount = new int[26];

        for(int i = 0; i < word.length() ; i++){
            char c = word.charAt(i);
            charCount[c - 'a']++;
        }

        for(int i = 0 ; i < 26; i++){
            if(counts[i] < charCount[i]){
                return false;
            }
        }

        return true;
    }

    private void reduceWordCount(String word, int[] counts){

        for(int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            counts[c - 'a']--;
        }
    }

    private void increarseWordCount(String word, int[] counts){

        for(int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            counts[c - 'a']++;
        }
    }

    private void createWordScore(String[] words, Map<String, Integer> wordScores, int[] score){

        for(String word : words){
            int wordScore = 0;
            for(int i = 0 ; i < word.length() ; i++){
                char c = word.charAt(i);
                wordScore += score[c-'a'];
            }
            wordScores.put(word, wordScore);
        }
    }

    private void maxScoreWords(String[] words, Map<String, Integer> wordScores, int start, int currentScore, int[] counts) {

        if(start == words.length){
            maxScore = Math.max(maxScore, currentScore);
            return;
        }

        String word = words[start];

        if(isPossible(word, counts)){
            reduceWordCount(word, counts);
            int wordScore = wordScores.get(word); 
            maxScoreWords(words, wordScores, start + 1, currentScore + wordScore, counts);
            increarseWordCount(word, counts);
        }
        maxScoreWords(words, wordScores, start + 1, currentScore, counts);
              
    }
    
    

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        int[] counts = new int[26];
        createWordCount(letters, counts);

        Map<String, Integer> wordScores = new HashMap<>();
        createWordScore(words, wordScores, score);

        maxScoreWords(words, wordScores, 0, 0, counts);

        return maxScore;
    }
}