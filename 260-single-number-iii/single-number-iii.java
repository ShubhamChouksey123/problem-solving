class Solution {
    private boolean isNthBitSet(long num, long nth) {

        num = num >> nth;

        if ((num & 1) == 1) {
            return true;
        }
        return false;
    }

    public int[] singleNumber(int[] nums) {

        long xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        long nth = 0;
        while ((xor & 1) == 0) {
            xor >>= 1;
            nth++;
        }


        long firstNumber = 0;
        long secondNumber = 0;
        for (int num : nums) {
            if (isNthBitSet(num, nth)) {
                firstNumber ^= num;
            } else {
                secondNumber ^= num;
            }
        }

        return new int[]{(int) firstNumber, (int) secondNumber};
    }
}