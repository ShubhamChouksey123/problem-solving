class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (n == 1) {
            return 0;
        }

        int profit = 0;
        int i = 0;
        int buy = 0;
        int sell = 0;
        while (i < n) {

            while (i + 1 < n && prices[i] > prices[i + 1]) {
                i++;
            }
            buy = prices[i];

            while (i + 1 < n && prices[i] < prices[i + 1]) {
                i++;
            }
            sell = prices[i];
            System.out.println("new profit : " + (sell - buy));

            profit += sell - buy;
            System.out.println("total profit : " + profit);
            i++;
        }

        System.out.println("profit : " + profit);

        return profit;
    }
}