class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(m > n){
            return false;
        }

        int index1 = 0;
        for(int i = 0 ; i < n ; i++){
            
            if( index1 < m && s.charAt(index1) == t.charAt(i)){
                index1++;
            }
        }    

        if(index1 == m){
            return true;
        }
        return false;
    }
}