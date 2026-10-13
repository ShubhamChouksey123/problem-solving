class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        k = k - 1;
        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] time : times){   
            int u = time[0] - 1, v = time[1] - 1, w = time[2];
            adj[u].add(new int[]{v, w});
        }

        int[] minDistance = new int[n];
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        /**
            pq containing {node, distance}
         */
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{k, 0});
        minDistance[k] = 0;

        while(!pq.isEmpty()){

            int[] top = pq.poll();
            int node = top[0], dist = top[1];

            if(minDistance[node] < dist) continue;
            minDistance[node] = dist;

            for(int[] neighbourEdgeWeight : adj[node]){
                int neighbour = neighbourEdgeWeight[0];
                int currentDist = dist + neighbourEdgeWeight[1];

                if(currentDist < minDistance[neighbour]){
                    pq.add(new int[]{neighbour, currentDist});
                    minDistance[neighbour] = currentDist;
                }
            }
        }

        int maxTime = Integer.MIN_VALUE;
        for(int distance : minDistance){
            if(distance == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, distance);
        }
        return maxTime;
    }
}