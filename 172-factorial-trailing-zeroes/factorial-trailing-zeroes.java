class Solution {
    private int countFiveInExpansion(int num) {

        int count = 0;
        while (num > 0 && num % 5 == 0) {
            num = num / 5;
            count++;
        }

        return count;
    }

    private int nearestFive(int n) {
        int num = n;
        while (num % 5 != 0) {
            num--;
        }
        return num;
    }

    public int trailingZeroes(int n) {

        n = nearestFive(n);
        int num = n;
        int count = 0;
        for (int i = num; i > 0; i = i - 5) {
            count += countFiveInExpansion(i);
        }

        return count;
    }
}