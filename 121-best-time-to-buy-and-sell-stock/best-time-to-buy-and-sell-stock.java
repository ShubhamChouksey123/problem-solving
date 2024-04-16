class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        if (n <= 1)
            return 0;


        int[] maxElementRight = new int[n];
        int maxTilNow = 0;

        maxElementRight[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            maxTilNow = Math.max(maxTilNow, prices[i + 1]);
            maxElementRight[i] = maxTilNow;
        }

        // System.out.println("maxElementRight : " + Arrays.toString(maxElementRight));

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, maxElementRight[i] - prices[i]);
        }


        // System.out.println("maxProfit : " + maxProfit);
        return maxProfit;
    }
}