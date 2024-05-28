class Solution {
    public int equalSubstring(String s, String t, int maxCost) {

        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int start = 0, sum = 0, maxLength = 0;

        for (int end = 0; end < n; end++) {
            sum += arr[end];
            while (sum > maxCost && start < end) {
                sum = sum - arr[start];
                start++;
            }
            if (sum <= maxCost) {
                maxLength = Math.max(maxLength, end - start + 1);
            }

        }

        return maxLength;
    }
}