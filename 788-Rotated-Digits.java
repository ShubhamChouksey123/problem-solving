class Solution {

    private boolean isGoodNum(int x){

        int num = x;
        boolean containsDiff = false;
        while(num > 0){
            int lastDigit = num % 10;
            
            if(lastDigit == 3 || lastDigit == 4 || lastDigit == 7){
                return false;
            }
            if(lastDigit == 2 || lastDigit == 5 || lastDigit == 6 || lastDigit == 9){
                containsDiff = true;
            }   
            num = num / 10;
            
        }
        return containsDiff;
    }

    public int rotatedDigits(int n) {
        
        int count = 0;
        for(int i = 1 ; i <= n ; i++){
            if(isGoodNum(i)) {
                count++;
            }
        }
        return count;
    }
}