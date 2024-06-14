class Solution {
    private boolean isPerfectSquare(int num) {

        int rootValue = (int) Math.sqrt(num);

        if (rootValue * rootValue == num) {
            return true;
        }

        return false;
    }

    public boolean judgeSquareSum(int c) {

        if (c < 2) {
            return true;
        }

        for (int a = 0; a < Math.sqrt(c); a++) {
            int b = c - (a * a);

            if (isPerfectSquare(b)) {
                return true;
            }
        }

        return false;
    }
}