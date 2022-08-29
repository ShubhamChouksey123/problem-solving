class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int costLast = cost[1];
        int costSecondLast = cost[0];
        int thisCost = Math.min(costLast , costSecondLast);
        
        for(int i = 2 ; i < n ; i++){
            thisCost = cost[i] + Math.min(costLast , costSecondLast);
            costSecondLast = costLast;
            costLast = thisCost;
        }
        
        return Math.min(costLast , costSecondLast);
    }
}