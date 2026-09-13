class Solution {
    
    public int longestCommonSubsequence(String text1, String text2, int[][] memoCache, int index1, int index2) {
        
        if(index1 == text1.length() || index2 == text2.length()) return 0;
        if(memoCache[index1][index2] != -1) return memoCache[index1][index2];

        if(text1.charAt(index1) == text2.charAt(index2)){
            return 1 + longestCommonSubsequence(text1, text2, memoCache, index1 + 1, index2 + 1); 
        }

        int a = longestCommonSubsequence(text1, text2, memoCache, index1 + 1, index2); 
        int b = longestCommonSubsequence(text1, text2, memoCache, index1, index2 + 1);

        return memoCache[index1][index2] = Math.max(a, b);
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] memoCache = new int[text1.length()][text2.length()];
        for(int[] row : memoCache){
            Arrays.fill(row, -1);
        }
        return longestCommonSubsequence(text1, text2, memoCache, 0, 0);
    }
}