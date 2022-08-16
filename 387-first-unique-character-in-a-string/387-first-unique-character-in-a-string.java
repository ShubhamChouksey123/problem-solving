class Solution {
    
    public int firstUniqChar(String s) {
        
        int[] lookUp = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            Character c = s.charAt(i);
            lookUp[c-'a']++;
        }
        
        for(int i = 0 ; i < s.length() ; i++){
            Character c = s.charAt(i);
            if(lookUp[c-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}