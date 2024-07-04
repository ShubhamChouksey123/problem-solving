class Solution {

    private int maxProfitUtil(int[] prices, int n, int index, int buy, int times) {
        if(index == n || times == 0){
            return 0;
        }
        
        if(buy == 1){
            return Math.max(
                - prices[index] +  maxProfitUtil(prices, n, index+1, 0, times), 
                0 + maxProfitUtil(prices, n, index+1, 1, times)
            );
        }


        return Math.max(
                prices[index] +  maxProfitUtil(prices, n, index+1, 1, times - 1), 
                0 + maxProfitUtil(prices, n, index+1, 0, times)
            );


            
    }

    private int maxProfitUtil(int[] prices, int n, int index, int buy, int times, int[][][] dp) {
        if(index == n || times == 0){
            return 0;
        }

        if(dp[index][buy][times] != -1){
            return dp[index][buy][times] ;
        }
        
        if(buy == 1){

            dp[index][buy][times] = 
            Math.max(
                - prices[index] +  maxProfitUtil(prices, n, index+1, 0, times), 
                0 + maxProfitUtil(prices, n, index+1, 1, times)
            );
            return dp[index][buy][times] ;
        }

        dp[index][buy][times] = Math.max(
                prices[index] +  maxProfitUtil(prices, n, index+1, 1, times - 1), 
                0 + maxProfitUtil(prices, n, index+1, 0, times)
            );

        return dp[index][buy][times];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        // for(int[][] inner1 : dp){
        //     for(int[] inner2 : inner1){
        //         Arrays.fill(inner2, -1);
        //     }
        // }

        // System.out.println("dp : " + Arrays.deepToString(dp));

        for(int index = n - 1; index >= 0 ; index--){
            for(int buy = 0; buy <= 1 ; buy++){
                for(int times = 1 ; times <= 2; times++){

                    if(buy == 1){
                        dp[index][buy][times] = Math.max(- prices[index] +  dp[index+1][0][times],  0 + dp[index+1][1][times]);
                    }else{
                        dp[index][buy][times] = Math.max(prices[index] +  dp[index+1][1][times - 1], 0 + dp[index+1][0][times]);
                    }

                }
            }
        }

        /**
        * recursive solution
        // return maxProfitUtil(prices, n, 0, 1, 2);
         */
         
        return dp[0][1][2]; 
    }
}