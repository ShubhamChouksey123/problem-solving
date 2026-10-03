class Solution {
    public int firstUniqChar(String s) {

        int[] count = new int[26];

        char[] chars = s.toCharArray();
        for(char c : chars){
            count[c - 'a']++;
        }

        for(int i = 0 ; i < s.length() ; i++){
            if(count[chars[i] - 'a'] == 1) return i;
        }       
        return -1;
    }
}