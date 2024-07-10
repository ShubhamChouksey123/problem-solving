class Solution {

    private int count = 0;

    private void countOddLengthAtIndex(String s, int n, int index) {

        int length = 0;
        while(index + length < n && index - length >= 0){
            if(s.charAt(index + length) != s.charAt(index - length)){
                break;
            }
            count++;
            length++;
        }

    }

    private void countEvenLengthAtIndex(String s, int n, int index) {

        int start = index, end = index +1;
        while(end < n && start >= 0){
            if(s.charAt(end) != s.charAt(start)){
                break;
            }
            count ++;
            start--;
            end++;
        }

    }

    private void countOddLength(String s, int n) {
        for(int i = 0 ; i < n ; i++){
            countOddLengthAtIndex(s, n, i);
        }
    }

    private void countEvenLength(String s, int n) {
        for(int i = 0 ; i < n - 1 ; i++){
            countEvenLengthAtIndex(s, n, i);
        }
    }

    public int countSubstrings(String s) {
        this.count = 0;
        int n = s.length();
        countEvenLength(s, n);
        countOddLength(s, n);

        return count ;
    }
}