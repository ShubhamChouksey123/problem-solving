class Solution {
    private int[] createArrayOfCount(String word) {
        int[] chars = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            chars[c - 'a']++;
        }
        return chars;
    }


    private void modifyOriginalCount(int[] originalCount, int[] currentCount) {
        for (int i = 0; i < 26; i++) {
            originalCount[i] = Math.min(originalCount[i], currentCount[i]);
        }
    }

    public List<String> commonChars(String[] words) {

        int n = words.length;
        int[] originalCount = createArrayOfCount(words[0]);

        for (int i = 1; i < n; i++) {
            int[] currentCount = createArrayOfCount(words[i]);
            modifyOriginalCount(originalCount, currentCount);
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (originalCount[i] > 0) {
                char c = (char) ('a' + i);
                ans.add(String.valueOf(c));
                originalCount[i]--;
            }
        }

        return ans;
    }
}