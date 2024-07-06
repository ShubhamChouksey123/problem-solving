class Solution {
    
    public int minCostClimbingStairs(int[] cost, int index, int costPayed) {
        if(index >= cost.length){
            return costPayed;
        }

        costPayed += cost[index] ;
        int oneStepCost = minCostClimbingStairs(cost, index + 1, costPayed); 
        int twoStepCost = minCostClimbingStairs(cost, index + 2, costPayed); 

        return Math.min(oneStepCost, twoStepCost);

    }

    public int minCostClimbingStairsUtil(int[] cost, int index, int[] minCostAt) {
        if(index >= cost.length){
            return 0;
        }
        if(index < 0){
            return 0;
        }

        if(index == 0 || index == 1){
            return cost[index];
        }
        if(minCostAt[index] != -1){
            return minCostAt[index];
        }

        int oneStepCost = minCostClimbingStairsUtil(cost, index - 1, minCostAt); 
        int twoStepCost = minCostClimbingStairsUtil(cost, index - 2, minCostAt); 

        minCostAt[index] = Math.min(oneStepCost, twoStepCost) + cost[index];
        // System.out.println("minCostAt[" + index + "] : " + minCostAt[index] );
        return minCostAt[index];

    }
    
    public int minCostClimbingStairs(int[] cost) {
        
        // recursive
        // return Math.min(minCostClimbingStairs(cost, 0, 0), minCostClimbingStairs(cost, 1, 0));


        int n = cost.length;
        int[] minCostAt = new int[n];
        Arrays.fill(minCostAt, -1);
        minCostAt[0] = cost[0];
        minCostAt[1] = cost[1];

        minCostClimbingStairsUtil(cost, n-1, minCostAt);
        return Math.min(minCostAt[n-1], minCostAt[n-2]);
    }
}