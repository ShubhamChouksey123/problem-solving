class Solution {

    public int secondsToRemoveOccurrences(String s) {

        char[] chars = s.toCharArray();
        int n = chars.length;
        int time = 0;

        while(true){
            int index = 0;
            boolean reverseSorted = true;
            while(index < n){
                if(index + 1 < n && chars[index] == '0' && chars[index + 1] == '1'){
                    chars[index] = '1'; chars[index + 1] = '0'; index = index + 2; reverseSorted = false;
                }
                else {
                    index++;
                }
            }
            if(reverseSorted) {
                break;
            }
            else time++;
        }

        return time;
        
    }
}