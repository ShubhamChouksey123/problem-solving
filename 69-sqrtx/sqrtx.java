class Solution {
    public long mySqrt(int x, long start, long end) {

        if (start == end) {
            return start;
        }


        long mid = (start + end) / 2;

        if (mid * mid == x) {
            return mid;
        }
        if ((mid + 1) * (mid + 1) > x && (mid * mid < x)) {
            return mid;
        }

        if (mid * mid > x) {
            return mySqrt(x, start, mid - 1);
        }
        return mySqrt(x, mid + 1, end);
    }

    public int mySqrt(int x) {

        if (x == 0)
            return 0;
        if (x == 1 || x == 2 || x == 3) {
            return 1;
        }
        return (int) mySqrt(x, (long) 2, (long) x / 2);
    }
}