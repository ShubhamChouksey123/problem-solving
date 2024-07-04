class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length; 
        int[][][] dp = new int[n+1][2][k+1];

        for(int index = n-1 ; index >= 0 ; index--){
            for(int buy = 0; buy <= 1 ; buy++){
                for(int times = 1; times <= k ; times++){
                    System.out.println("index : " + index + " buy : " + buy + " and times : " + times);
                    if(buy == 1){
                        dp[index][buy][times] = Math.max(-prices[index] + dp[index+1][0][times]  , dp[index+1][1][times]);
                    }
                    else{ 
                        dp[index][buy][times] = Math.max( prices[index] + dp[index+1][1][times-1], dp[index+1][0][times]);
                    }
                }
            }
        } 

        return dp[0][1][k];
        
    }
}


/**

dp[i][j][k] =>  ith day, j= 0(buy) 1(sell) 2 (skip) , k 


dp[n][2]
3,2,6,5,0,3
 */