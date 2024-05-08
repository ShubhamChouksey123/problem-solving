class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;

        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            int num = digits[i] + carry;
            if (num == 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = num;
                carry = 0;
            }
        }

        if (carry == 0) {
            return digits;
        }

        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}