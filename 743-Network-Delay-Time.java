class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++) adj[i] = new ArrayList<>();   

        for(int[] time : times){
            int u = time[0] - 1, v = time[1] - 1, w = time[2];
            adj[u].add(new int[]{v, w});
        }

        k--;
        int[] minDistance = new int[n];
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        // priority queue containing {node, currentDistance from source}
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        queue.add(new int[]{k , 0});
        minDistance[k] = 0;

        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int node = top[0], distance = top[1];

            if(minDistance[node] < distance) continue;

            for(int[] neighbourEdge : adj[node]){
                int neighbour = neighbourEdge[0];
                int neighbourDistance = distance + neighbourEdge[1];

                if(minDistance[neighbour] > neighbourDistance){
                    minDistance[neighbour] = neighbourDistance;
                    queue.add(new int[]{neighbour , neighbourDistance});
                }
            }
        }

        int maxTime = 0;
        for(int time : minDistance){
            if(time == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }
}