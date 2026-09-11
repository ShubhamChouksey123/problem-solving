class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }

        int u = 0, v = 0, t = 0;
        for(int[] time : times){
            u = time[0] - 1; v = time[1] - 1; t = time[2]; 
            adj[u].add(new int[]{v, t});
        }
        k = k - 1;

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        queue.add(new int[]{0, k});
        int[] minDistance = new int[n];
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        while(!queue.isEmpty()){
            
            int[] distanceNode = queue.poll();
            int node = distanceNode[1];
            int distance = distanceNode[0];

            if(minDistance[node] < distance) continue;
            minDistance[node] = distance;

            for(int[] neighbourDistance : adj[node]){

                int neighbourNode = neighbourDistance[0];
                int edgeWeight = neighbourDistance[1];
                if(minDistance[neighbourNode] > distance + edgeWeight){
                    minDistance[neighbourNode] = distance + edgeWeight;
                    queue.add(new int[]{minDistance[neighbourNode], neighbourNode});
                }
            }
        }

        int maxDistanceFromSource = 0;
        for(int i = 0 ; i < n ; i++){
            if(minDistance[i] == Integer.MAX_VALUE) return -1;
            maxDistanceFromSource = Math.max(maxDistanceFromSource, minDistance[i]);
        }
        return maxDistanceFromSource;

    }
}