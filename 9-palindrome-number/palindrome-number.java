class Solution {
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        int n = num.length();

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) != num.charAt(n - i - 1)) {
                return false;
            }
        }
        
        return true;       
    }
}