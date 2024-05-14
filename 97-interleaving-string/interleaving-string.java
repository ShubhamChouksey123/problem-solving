class Solution {
    private void prepareInitialEdgeCases(String s1, String s2, String s3, int n1, int n2, int m, boolean[][] dp) {

        dp[n1][n2] = true;

        for (int j = n2 - 1; j >= 0; j--) {

            if (!dp[n1][j + 1]) {
                break;
            }
            char charS2 = s2.charAt(j);
            char charS3 = s3.charAt(n1 + j);

            if (charS2 == charS3) {
                dp[n1][j] = true;
            }
        }

        for (int i = n1 - 1; i >= 0; i--) {

            if (!dp[i + 1][n2]) {
                break;
            }
            char charS1 = s1.charAt(i);
            char charS3 = s3.charAt(n2 + i);

            if (charS1 == charS3) {
                dp[i][n2] = true;
            }
        }
    }


    public boolean isInterleave(String s1, String s2, String s3) {


        int n1 = s1.length();
        int n2 = s2.length();

        int m = s3.length();
        if (n1 + n2 != m) {
            return false;
        }


        boolean[][] dp = new boolean[n1 + 1][n2 + 1];

        prepareInitialEdgeCases(s1, s2, s3, n1, n2, m, dp);


        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {

                char charS3 = s3.charAt(i + j);

                char charS1 = s1.charAt(i);
                if (charS1 == charS3 && dp[i + 1][j]) {
                    dp[i][j] = true;
                    continue;
                }

                char charS2 = s2.charAt(j);
                if (charS2 == charS3 && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[0][0];
    }
}