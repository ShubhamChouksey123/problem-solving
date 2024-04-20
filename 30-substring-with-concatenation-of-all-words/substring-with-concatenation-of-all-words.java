class Solution {

    /**
     * Time complexity : O(totalWords * length)
     * Space Complexity : O(totalWords * length)
     *
     * @param s
     * @param timesOriginal
     * @param length
     * @param totalWords
     * @return
     */
    private static boolean isSubString(String s, HashMap<String, Integer> timesOriginal, int length, int totalWords) {

        HashMap<String, Integer> times = new HashMap<>(timesOriginal);

        for (int i = 0; i < totalWords; i++) {
            // System.out.println("first index : " + i * length + " and length : " + length);
            String nthWord = s.substring(i * length, length + i * length);
            Integer previousCount = times.get(nthWord);
            if (previousCount == null || previousCount == 0) {
                return false;
            }
            times.replace(nthWord, --previousCount);
        }

        return true;
    }

    /**
     * Time Complexity : O(n * length * totalWords)
     * Space Complexity : O(totalWords)
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {

        int totalWords = words.length;
        int length = words[0].length();

        List<Integer> indexes = new ArrayList<>();

        HashMap<String, Integer> times = new HashMap<>();
        for (int i = 0; i < totalWords; i++) {
            if (times.get(words[i]) == null) {
                times.put(words[i], 1);
            } else {
                int count = times.get(words[i]);
                times.replace(words[i], ++count);
            }
        }

        int n = s.length();
        for (int i = 0; i <= n - (totalWords * length); i++) {
            String substr = s.substring(i, i + totalWords * length);
            boolean isSubString = isSubString(substr, times, length, totalWords);

            if (isSubString) {
                indexes.add(i);
            }
        }

        return indexes;
        
    }
}