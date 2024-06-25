class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int index1 = 0, index2 = 0, m = word1.length(), n = word2.length();

        StringBuilder str = new StringBuilder();
        while(index1 < m || index2 < n){
            if(index1 < m){
                str.append(word1.charAt(index1));
                index1++;
            }
            if(index2 < n){
                str.append(word2.charAt(index2));
                index2++;
            }
        }

        return str.toString();
    }
}