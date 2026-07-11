class Solution {

    private boolean isGoodNum(int x){

        int num = x;
        int index = 0;
        int rotatedNumber = 0;

        while(num > 0){
            int lastDigit = num % 10;
            num = num / 10;
            if(lastDigit == 3 || lastDigit == 4 || lastDigit == 7){
                return false;
            }
            int rotatedDigit = 0;
            switch(lastDigit){
                case 2: 
                    rotatedDigit = 5;
                    break;
                case 5: 
                    rotatedDigit = 2;
                    break;
                case 6: 
                    rotatedDigit = 9;
                    break;
                case 9:
                    rotatedDigit = 6;
                    break;
                default:
                   rotatedDigit = lastDigit;
                   break;
            }
            
            rotatedNumber = (rotatedDigit * (int)Math.pow(10, index )) +  rotatedNumber; 
            index++;
            
        }
        return (x != rotatedNumber);
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