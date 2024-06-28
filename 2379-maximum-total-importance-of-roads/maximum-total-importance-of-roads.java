class Solution {
    
    
    public long maximumImportance(int n, int[][] roads) {
       
        int[] counts = new int[n];

        for(int[] road : roads){
            counts[road[0]]++;
            counts[road[1]]++;
        }

        Queue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < n ; i++){
            pq.add(counts[i]);
        }

        long score = 0; int assignedNumber = 1;
        while(!pq.isEmpty()){
            int times = pq.poll();
            score += ((long)assignedNumber * times);
            assignedNumber++;
        }

        return score;
    }
}