class Solution {
    public int appendCharacters(String s, String t) {

        int m = s.length();
        int n = t.length();

        int indexOnT = 0;
        for (int i = 0; i < m; i++) {
            if (indexOnT == n) {
                break;
            }
            if (s.charAt(i) == t.charAt(indexOnT)) {
                indexOnT++;
            }
        }

        return n - indexOnT;
    }
}