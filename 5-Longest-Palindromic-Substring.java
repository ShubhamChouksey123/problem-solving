class Solution {
    
    private String maxLengthPalString;
    private int maxLengthPalStringLength;
    
    private void findPalUntil(String s, int n, int start, int end){
        
        int length = 0;
        while(start >= 0 && end < n && s.charAt(start) == s.charAt(end)){
            length = end - start + 1;
            if(length > maxLengthPalStringLength){
                maxLengthPalStringLength = length;
                maxLengthPalString = s.substring(start, end + 1);
            }
            start --;
            end ++;
        }
        
    }
    
    public String longestPalindrome(String s) {
        
        maxLengthPalStringLength = 0;
        int n = s.length();
        
        for(int i = 0 ; i < n ; i++){
            findPalUntil(s, n, i, i);
        }
        
        for(int i = 0 ; i < n ; i++){
            findPalUntil(s, n, i, i + 1);
        }
        
        return maxLengthPalString;
    }
}