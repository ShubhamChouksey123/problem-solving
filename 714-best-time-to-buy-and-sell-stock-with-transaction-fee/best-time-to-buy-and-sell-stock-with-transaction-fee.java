class Solution {
    
    private int maxProfit(int[] prices, int fee, int day, int canBuy, int[][] maxProf) {

        if(day == prices.length){
            return 0;
        }

        if(maxProf[day][canBuy] !=- 1){
            return maxProf[day][canBuy];
        }

        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE; 
        if(canBuy == 1){
            a = - prices[day] +  maxProfit(prices, fee, day + 1, 0, maxProf); 
        }
        b = maxProfit(prices, fee, day + 1, canBuy, maxProf);

        if(canBuy == 0){
            c = prices[day] - fee + maxProfit(prices, fee, day + 1, 1, maxProf); 
        }
        maxProf[day][canBuy] = Math.max(Math.max(a, b), c);
        return maxProf[day][canBuy];
    }
    
    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;
        int[][] maxProf = new int[n][2] ;
        for(int[] inner: maxProf){
            Arrays.fill(inner, -1);
        }


        return maxProfit(prices, fee, 0, 1, maxProf);

    }
}