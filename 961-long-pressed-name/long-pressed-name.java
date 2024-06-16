class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int m = name.length();
        int n = typed.length();

        int i = 0;
        int j = 0;
        for(; j < n ;){
            if(i < m && name.charAt(i) == typed.charAt(j)){
                i++; j++;
            }else if(j > 0 && typed.charAt(j-1) == typed.charAt(j)){
                j++;
            }else{
                return false;
            }
        }

        if(i == m && j == n){
            return true;
        }
        return false;
    }
}