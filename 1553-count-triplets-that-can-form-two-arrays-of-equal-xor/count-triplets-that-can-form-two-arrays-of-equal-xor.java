class Solution {
    public int countTriplets(int[] arr) {

        int n = arr.length;
        if (n <= 1) {
            return 0;
        }

        int count = 0;
        int a = 0, b = 0;

        for (int i = 0; i < n - 1; i++) {
            a = 0;
            for (int j = i + 1; j < n; j++) {
                a = a ^ arr[j - 1];
                b = 0;
                for (int k = j; k < n; k++) {
                    b = b ^ arr[k];
                    if (a == b) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}