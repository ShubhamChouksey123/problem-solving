class Solution {

    private List<String> ans ; 

    private void addList(List<String> words){
        int n = words.size();
        if(n < 1){
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(words.get(0));
        for(int i = 1 ; i < words.size() ; i++){
            stringBuilder.append(" ");
            stringBuilder.append(words.get(i));
        }

        ans.add(stringBuilder.toString());
    }

    private boolean isMatchesSubStr(String s, int index, String word){

        int expectedLength = word.length();

        if(s.length() - index < expectedLength){
            return false;
        }

        String actualStr = s.substring(index, index + expectedLength);

        if(Objects.equals(word, actualStr)){
            return true;
        }
        return false;

    }

    private void wordBreak(String s, List<String> wordDict, int index, List<String> words) {
        if(s.length() == index){
            addList(words);
            return ;
        }

        for(String word : wordDict){
            if(isMatchesSubStr(s, index, word)){
                words.add(word);
                wordBreak(s, wordDict, index + word.length(), words);
                words.remove(words.size() - 1);
            }
        }
    }


    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        wordBreak(s, wordDict, 0, new ArrayList<>());

        return ans; 
    }
}