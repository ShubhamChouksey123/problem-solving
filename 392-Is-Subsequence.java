class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int n = s.length(), m = t.length();
        if(n > m) return false;
        if(n == 0) return true;

        int indexInS = 0;
        for(int i = 0 ; i < m ; i++){
            if(t.charAt(i) == s.charAt(indexInS)){
                indexInS++;
                if(indexInS == n) return true;
            }
        } 
        return false;
    }
}