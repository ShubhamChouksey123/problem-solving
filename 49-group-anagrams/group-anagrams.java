class Solution {

    /**
     * String "ate" will return a1e1t1
     * String "tan" will return a1n1t1
     *
     * @param word
     * @return the string consisting of count of each character
     */
    public String generateKeysCountString(String word) {
        StringBuilder keysCountString = new StringBuilder();
        int[] count = new int[26];

        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {

                char c = (char) ('a' + i);

                keysCountString.append(c);
                keysCountString.append(count[i]);
            }
        }
        return keysCountString.toString();
    }


        /**
     * <ul>
     *     <li>will get the keyCountString of each word.</li>
     *     <li>map a map of key as the keyCountString with the mapped value as the word</li>
     * </ul>
     *
     *
     * @param
     * @return the string consisting of count of each character
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        int n = strs.length;
        Map<String, List<String>> mp = new HashMap<>();


        for (int i = 0; i < n; i++) {
            String keysCountString = generateKeysCountString(strs[i]);

            if (mp.get(keysCountString) == null) {
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                mp.put(keysCountString, group);
            } else {
                List<String> group = mp.get(keysCountString);
                group.add(strs[i]);
                mp.replace(keysCountString, group);
            }
        }

        return new ArrayList<>(mp.values());
        
    }
}