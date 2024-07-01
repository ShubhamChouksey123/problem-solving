class Solution {

    private int getLengthAffected(int count){
        int add = 0;
        if(count == 1){
            add = 1;
        }else if(count <= 9){
            add = 2;
        }else{
            int countLength = String.valueOf(count).length();
            add = 1 + countLength; 
        }
        return add;
    }

    public int compress1(char[] chars) {
        
        int n = chars.length, count = 1, length = 0;
        char lastChar = chars[0];
        for(int i = 1 ; i < n ; i++){
            char c = chars[i];
            if(c == lastChar){
                count++;
                continue;
            }else{
                length += getLengthAffected(count); 
                count = 1;
                lastChar = c;
            }
        }
        length += getLengthAffected(count); 
        return length;

    }

    private int addCountChars(char[] chars, int count, int startIndex){
        int add = 0;
        if(count == 1){
            return startIndex;
        }

        String countStr = String.valueOf(count);
        for(int i = 0 ; i < countStr.length() ; i++){
            chars[startIndex] = countStr.charAt(i);
            startIndex++;
        }
        return startIndex;
    }

    public int compress(char[] chars) {
        
        int n = chars.length, count = 1, length = 0, startIndex = 0;
        char lastChar = chars[0];

        for(int i = 1 ; i < n ; i++){
            char c = chars[i];
            if(c == lastChar){
                count++;
                continue;
            }else{
                chars[startIndex] = lastChar;
                startIndex = addCountChars(chars, count, startIndex+1);
                count = 1;
                lastChar = c;
            }
        }
        chars[startIndex] = lastChar;
        startIndex = addCountChars(chars, count, startIndex+1);
        return startIndex;
    }
}