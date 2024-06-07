class Solution {
    
    private String getShortestPrefix(String word, List<String> dictionary) {

        for (int i = 0; i < dictionary.size(); i++) {
            String prefix = dictionary.get(i);
            if (prefix.length() > word.length()) {
                continue;
            }
            String expectedCommonPart = word.substring(0, prefix.length());
            if (Objects.equals(expectedCommonPart, prefix)) {
                word = prefix;
            }
        }
        return word;
    }


    public String replaceWords(List<String> dictionary, String sentence) {


        List<String> words = Arrays.asList(sentence.split("\\s+"));

        String ans = "";
        if (words.isEmpty()) {
            return ans;
        }

        ans = getShortestPrefix(words.get(0), dictionary);

        for (int i = 1; i < words.size(); i++) {
            String word = words.get(i);
            ans = ans + " " + getShortestPrefix(word, dictionary);
        }
        return ans;
    }

}