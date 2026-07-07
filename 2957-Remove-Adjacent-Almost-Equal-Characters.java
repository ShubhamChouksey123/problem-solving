class Solution {
    public int removeAlmostEqualCharacters(String word) {

        int n = word.length();
        int operation = 0;
        
        for(int i = 1 ; i < n ; i++){
            if( Math.abs(word.charAt(i) - word.charAt(i-1)) <= 1) {
                operation++;
                i++;
            }
        } 

        return operation;   
    }
}