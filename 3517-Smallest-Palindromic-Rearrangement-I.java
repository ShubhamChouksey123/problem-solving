class Solution {

    private static final int TOTAL_CHARS = 26;

    public String smallestPalindrome(String s) {

        int[] charCount = new int[TOTAL_CHARS];
        for(char c : s.toCharArray()){
            charCount[c - 'a']++;
        } 
        
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < TOTAL_CHARS ; i++){
            char c = (char)('a' + i);
            for(int j = 0 ; j < charCount[i] / 2 ; j++){
                builder.append(c);
            }
        }

        String firstHalf = builder.toString();
        if(s.length() % 2 != 0){
            firstHalf = firstHalf + s.charAt(s.length()/2);
        }
        String secondHalf = builder.reverse().toString();
        return firstHalf + secondHalf; 
    }
}