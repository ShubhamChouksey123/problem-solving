class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mp = new HashMap<>();
        Set<String> setOfWords = new HashSet<>();


        int n = s.length();
        int indexOfChar = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder word = new StringBuilder();
            while (i < n && s.charAt(i) != ' ') {
                word.append(s.charAt(i));
                i++;
            }

            String actualWord = word.toString();

            if (indexOfChar >= pattern.length()) {
                return false;
            }

            char currentChar = pattern.charAt(indexOfChar);
            String expectedWord = mp.get(currentChar);

            if (expectedWord == null) {
                mp.put(currentChar, actualWord);
                setOfWords.add(actualWord);
            } else if (!Objects.equals(expectedWord, actualWord)) {
                System.out.println("not matching for word : " + actualWord + " expected : " + expectedWord);
                return false;
            }
            indexOfChar++;
        }

        if (indexOfChar < pattern.length()) {
            return false;
        }
        if(setOfWords.size() != mp.size())
            return false;

        return true;
    }
}