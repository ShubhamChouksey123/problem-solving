class Solution {

    private boolean isVoWel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ){
            return true;
        }
        else if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ){
            return true;
        }
        return false;
    }

    private void swap(String s, int start, int end){


    }

    public String reverseVowels(String s) {
        
        int n = s.length();
        int start = 0, end = n-1;
        char[] word = s.toCharArray();

        while(start < end){
            char schar = word[start];
            char echar = word[end];

            if(!isVoWel(schar)){
                start++;
            }
            else if(!isVoWel(echar)){
                end--;
            }else{
                char tmp = word[start];
                word[start] = word[end];
                word[end] = tmp;
                start++;
                end--;
            }
        } 

        return new String(word);
    }
}