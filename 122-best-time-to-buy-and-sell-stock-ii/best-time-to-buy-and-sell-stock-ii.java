class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int totalProfit = 0;
        int index = 0;
        while (index < n) {

            if (index + 1 < n && prices[index] >= prices[index + 1]) {
                index++;
                continue;
            }
            int start = index;
            while (index + 1 < n && prices[index] <= prices[index + 1]) {
                index = index + 1;
            }
            int currentProfit = prices[index] - prices[start];
            totalProfit += currentProfit;
            index++;
        }


        return totalProfit;
    }
}