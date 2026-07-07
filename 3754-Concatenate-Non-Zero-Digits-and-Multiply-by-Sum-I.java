class Solution {
    public long sumAndMultiply(int n) {

        if(n == 0) return 0;

        int sumOfDigits = 0;

        StringBuilder builder = new StringBuilder();  
        while(n > 0){
            int lastDigit = n % 10;
            if(lastDigit > 0){
                builder.append(lastDigit);
                sumOfDigits += lastDigit;
            }
            n = n / 10;
        }

        String x = builder.reverse().toString();
        long val = Long.valueOf(x) * sumOfDigits;
        return val;
    }
}