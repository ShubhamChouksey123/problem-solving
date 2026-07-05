class Solution {
    public int compress(char[] chars) {

        int n = chars.length;
        int index = 0;
        int newLength = 0;
        int modifiedArrayIndex = 0;

        while(index < n){
            
            int start = index;
            int end = index;
            while(end + 1 < n && chars[start] == chars[end + 1]){
                end++;
            }
            
            int len = end - start + 1;
            if(len == 1){
                chars[modifiedArrayIndex++] = chars[start];
                newLength += 1;
            }else{
                chars[modifiedArrayIndex++] = chars[start];
                int timesLength = String.valueOf(len).length();
                int tmp = modifiedArrayIndex + timesLength - 1;
                while(len > 0){
                    char c = (char)(len % 10 + '0');
                    chars[tmp--] = c;
                    len = len / 10;
                }
                modifiedArrayIndex = modifiedArrayIndex + timesLength;
                newLength += (1 + timesLength);
            }
            index = end + 1;
        }
        return newLength; 
    }
}