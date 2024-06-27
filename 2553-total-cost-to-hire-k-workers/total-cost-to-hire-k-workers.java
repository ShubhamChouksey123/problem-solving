class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        int n = costs.length; long totalCost = 0;
        int firstEnd = Math.min(n, candidates -1), lastStart = Math.max(0, n-candidates);
        Queue<Integer[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        );

        if(candidates * 2 >= n){
            for(int cost : costs){
                pq.add(new Integer[]{cost, 0});
            }
        }else{
            for(int i = 0 ; i <= firstEnd ; i++){
                pq.add(new Integer[]{costs[i], 0});
            }

            for(int i = n-1 ; i >= lastStart ; i--){
                pq.add(new Integer[]{costs[i], 1});
            }
        }


        while(k-- > 0){
            Integer[] top = pq.poll();
            totalCost += top[0];

            if(top[1] == 0 && firstEnd + 1 < lastStart){
                firstEnd++;
                pq.add(new Integer[]{costs[firstEnd], 0});
            }
            else if(top[1] == 1 && firstEnd < lastStart - 1){
                lastStart--;
                pq.add(new Integer[]{costs[lastStart], 1});
            }
        }
        return totalCost;
        
    }
}