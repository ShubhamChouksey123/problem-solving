public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        if (n == 0) {
            return 0;
        }

        BitSet bitSet = new BitSet(32);

        for (int i = 0; i < 32; i++) {
            int val = n & 1;
            if (val == 1) {
                bitSet.set(32 - i - 1);
            }
            n = n >> 1;
        }
        System.out.println("bitSet : " + bitSet);

        long l = bitSet.toLongArray()[0];
        System.out.println("l : " + l);
        return (int) l;
    }
}