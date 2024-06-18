class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int n = profit.length;

        Queue<Integer[]> profitQueue = new PriorityQueue<>(
            (Integer[] a, Integer[] b) -> {
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        );

        for(int i = 0 ; i < n ; i++){
            Integer[] ele = new Integer[]{difficulty[i], profit[i]};
            profitQueue.add(ele);
        }

        Arrays.sort(worker);

        int lastProfit = 0;
        int totalProfit = 0;
        for(int i = 0 ; i < worker.length ; i++){
            int capacity = worker[i];
            int currentProfit = lastProfit;
            while( !profitQueue.isEmpty() && profitQueue.peek()[0] <= capacity ){
                Integer[] top = profitQueue.poll(); 
                currentProfit = Math.max(top[1], currentProfit);
            }
            lastProfit = currentProfit;
            totalProfit += currentProfit;
        }

        return totalProfit;
    }
}