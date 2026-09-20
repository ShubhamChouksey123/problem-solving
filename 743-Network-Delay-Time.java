class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }

        int u = 0, v = 0, w = 0;
        for(int[] time : times){
            u = time[0] - 1;
            v = time[1] - 1;
            w = time[2];
            adj[u].add(new int[]{v, w});
        }
        k = k - 1;

        int[] minDistance = new int[n];
        Arrays.fill(minDistance, Integer.MAX_VALUE);


        /**
            Priority queue containing (node, weight)
         */
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{k, 0});
        

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int node = top[0];
            int distance = top[1];

            if(minDistance[node] < distance) continue;
            minDistance[node] = distance;

            for(int[] neighbourNodeInfo : adj[node]){
                int newDistance = distance + neighbourNodeInfo[1];
                int neighbourNode =  neighbourNodeInfo[0];

                if(newDistance < minDistance[neighbourNode]){
                    pq.add(new int[]{neighbourNode, newDistance});
                    minDistance[neighbourNode] = newDistance;
                }
            }
        }

        int maxTime = 0;
        for(int i = 0 ; i < n ; i++){
            if(minDistance[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, minDistance[i]);
        }
        return maxTime;
        
    }
}