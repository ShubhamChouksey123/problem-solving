class Solution {

    public int numDistinct(String s, String t, int[][] memoCache, int sIndex, int tIndex) {
        
        if(sIndex == s.length() && tIndex < t.length()) return 0;
        if(sIndex == s.length() && tIndex == t.length()) return 1;
        if(tIndex == t.length()) return 1;
        if(sIndex > s.length() || tIndex > t.length()) return 0;
        if(memoCache[sIndex][tIndex] != -1) return memoCache[sIndex][tIndex];

        if(s.charAt(sIndex) != t.charAt(tIndex)){
            return numDistinct(s, t, memoCache, sIndex + 1, tIndex) ;
        }

        int take = numDistinct(s, t, memoCache, sIndex + 1, tIndex + 1) ;
        int notTake = numDistinct(s, t, memoCache, sIndex + 1, tIndex);
        
        int optimalValue = take + notTake;
        return memoCache[sIndex][tIndex] = optimalValue;
    }

    public int numDistinct(String s, String t) {
        
        int n = s.length(), m = t.length();
        int[][] memoCache = new int[n + 1][m + 1];
        for(int[] row : memoCache){
            Arrays.fill(row, -1);
        }
            
        return numDistinct(s, t, memoCache, 0, 0);
        
    }
}