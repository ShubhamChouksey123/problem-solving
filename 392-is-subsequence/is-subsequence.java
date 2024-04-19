class Solution {
    public boolean isSubsequence(String s, String t) {

        int n = s.length();
        int m = t.length();
        if (n > m) {
            return false;
        }

        int indexInT = 0;
        int countMatchWords = 0;
        for (int i = 0; i < n; i++) {
            while (indexInT < m && s.charAt(i) != t.charAt(indexInT)) {
                indexInT++;
            }
            if (indexInT < m && s.charAt(i) == t.charAt(indexInT)) {
                countMatchWords++;
                indexInT++;
            }
        }

        if (countMatchWords == n)
            return true;

        return false;
        
    }
}