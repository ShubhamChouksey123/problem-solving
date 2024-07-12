class Solution {
    
    public int longestCommonSubsequence(String text1, String text2, int end1, int end2, int[][] longCS) {

        if(end1 < 0 || end2 < 0){
            return 0;
        }

        if(longCS[end1][end2] != -1){
            return longCS[end1][end2];
        }

        char c1 = text1.charAt(end1), c2 = text2.charAt(end2);

        longCS[end1][end2] = 0;
        if(end1 > 0){
            longCS[end1][end2] = Math.max(longCS[end1][end2], 
                longestCommonSubsequence(text1, text2, end1 - 1, end2, longCS) 
            );
        }
        if(end2 > 0){
            longCS[end1][end2] = Math.max(longCS[end1][end2],
                longestCommonSubsequence(text1, text2, end1, end2 - 1, longCS) 
            );
        }
        
        if(c1 == c2 && (end1 == 0 || end2 == 0)){
            longCS[end1][end2] = Math.max(1, longCS[end1][end2]);
        }

        if(c1 == c2 && end1 > 0 && end2 > 0){
            longCS[end1][end2] = Math.max(longCS[end1][end2], 
                longestCommonSubsequence(text1, text2, end1 - 1, end2 - 1, longCS) + 1
            );
        }
        
        return longCS[end1][end2];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length(), n = text2.length();
        int[][] longCS = new int[m][n];
        for(int[] inner : longCS){
            Arrays.fill(inner, -1);
        }

        return longestCommonSubsequence(text1, text2, m-1, n-1, longCS);

    }
}