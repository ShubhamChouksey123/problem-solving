class Solution {
    public int maxProfit(int[] prices) {

        int totalProfit = 0;
        int n = prices.length;

        int index = 0;

        while(index < n){
            while(index + 1 < n && prices[index] > prices[index + 1]){
                index++;
            }
            int startIndex = index;

            while(index + 1 < n && prices[index] < prices[index + 1]){
                index++;
            }
            int endIndex = index;
            totalProfit += (prices[endIndex] - prices[startIndex]);
            index++;
        }
        return totalProfit;
    }
}