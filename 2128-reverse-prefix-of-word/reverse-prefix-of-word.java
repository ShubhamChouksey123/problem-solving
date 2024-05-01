class Solution {
    public String reversePrefix(String word, char ch) {

        int n = word.length();


        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (c == ch) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(word.substring(0, i+1));
                stringBuilder.reverse();
                if (i + 1 < n) {
                    stringBuilder.append(word.substring(i + 1, n ));
                }
                return stringBuilder.toString();
            }
        }
        return word;

    }
}