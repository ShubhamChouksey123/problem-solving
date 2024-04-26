class Solution {
   
    public int getSumOFSquareOfDigits(int n) {

        if (n == 0)
            return 0;

        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += (digit * digit);
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {

        if (n < 10) {
            if (n == 1 || n == 7)
                return true;
            else
                return false;
        }

        int sum = getSumOFSquareOfDigits(n);
        if (sum == 1) {
            return true;
        }

        return isHappy(sum);

    }
}