class Solution {
    
    private int countPal = 0;

    public boolean isPalindrome(String s, int start, int end) {
        
        for(int i = start ; i < end/2 ; i++){
            if(s.charAt(i) != s.charAt(end-i-1)){
                return false;
            }
        }
        return true;

    }

    public boolean isPalindrome(String s, int start, int end, int[][] isPal) {
        
        if(isPal[start][end] != -1){
            if(isPal[start][end] == 1){return true;}else{return false;} 
        }

        if(start == end){
            isPal[start][end] = 1;
            return true;
        }

        if(s.charAt(start) != s.charAt(end)){
            isPal[start][end] = 0;
            return false;
        }

        if(start + 1 == end){
            isPal[start][end] = 1;
            return true;
        }

        boolean isInner = isPalindrome(s, start+1, end-1, isPal);
        isPal[start][end] = (isInner == true) ? 1 : 0;
        
        if(isPal[start][end] == 1){return true;}else{return false;} 
    }


    public void countSubstringsUtil(String s, int start, int end, int[][] isPal) {

        // System.out.println("start : " + start + " and end : " + end);

        if(isPalindrome(s, start, end, isPal)){
            // System.out.println("pal for start : " + start + " and end : " + end);
            countPal++;
        }
    }
    
    public int countSubstrings(String s) {

        int n = s.length();
        countPal = 0;

        int[][] isPal = new int[n][n];
        for(int[] inner : isPal){
            Arrays.fill(inner, -1);
        }

        for(int i = 0; i < n ; i++){
            for(int j = i; j < n ; j++){
                countSubstringsUtil(s, i, j, isPal);
            }
        }

        return countPal;
    }
}