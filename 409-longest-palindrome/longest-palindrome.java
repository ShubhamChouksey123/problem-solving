class Solution {
    public int longestPalindrome(String s) {

        int[] small = new int[26];
        int[] big = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                small[c - 'a']++;
            } else {
                big[c - 'A']++;
            }
        }

        
        int count = 0;
        boolean isOdd = false;
        for (int i = 0; i < 26; i++) {
            count += 2 * (small[i] / 2);
            count += 2 * (big[i] / 2);

            if ((small[i] & 1) == 1) {
                isOdd = true;
            }
            if ((big[i] & 1) == 1) {
                isOdd = true;
            }
        }

        if (isOdd) {
            return count + 1;
        }
        return count;
    }
}