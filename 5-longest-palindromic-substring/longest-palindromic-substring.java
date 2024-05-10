class Solution {
    

    public String longestPalindrome(String s) {

        int n = s.length();
        boolean[][] longestPalLength = new boolean[n][n];

        int maxLength = 1;
        int maxLengthIndex = 0;
        for (int i = 0; i < n; i++) {
            longestPalLength[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                longestPalLength[i][i + 1] = true;
                maxLength = 2;
                maxLengthIndex = i;

            }
        }

        for (int len = 3; len <= n; len++) {
            int start = 0;
            for (int j = 0; j <= n - len; j++) {
                if (s.charAt(start) == s.charAt(start + len - 1) && longestPalLength[start + 1][start + len - 2]) {
                    longestPalLength[start][start + len - 1] = true;
                    if (len > maxLength) {
                        maxLength = len;
                        maxLengthIndex = start;
                    }

                }
                start++;
            }
        }



        return s.substring(maxLengthIndex, maxLengthIndex + maxLength);
    }

}