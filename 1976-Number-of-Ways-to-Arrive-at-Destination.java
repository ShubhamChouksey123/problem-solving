class Solution {

    private final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {

        List<long[]>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }   

        for(int[] road : roads){
            int u = road[0], v = road[1], t = road[2];
            adj[u].add(new long[]{v, t});
            adj[v].add(new long[]{u, t});
        }

        long[] minDistance = new long[n];
        Arrays.fill(minDistance, Long.MAX_VALUE);

        // priority queue containing (node , distance)
        Queue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});
        minDistance[0] = 0;
        int totalShotestPaths = 0;

        long[] ways = new long[n];
        ways[0] = 1;

        while(!pq.isEmpty()){
            long[] top = pq.poll();
            int node = (int)top[0]; long curDistance = top[1];
            
            if(curDistance > minDistance[node]) continue;

            for(long[] neighbourEdge : adj[node]){
                int neighbour = (int)neighbourEdge[0];
                long thisDistance = curDistance + neighbourEdge[1];

                if(thisDistance < minDistance[neighbour]){
                    minDistance[neighbour] = thisDistance;
                    ways[neighbour] = ways[node];
                    pq.offer(new long[]{neighbour, thisDistance});   
                }
                else if(thisDistance == minDistance[neighbour]){
                    ways[neighbour] = (ways[node] + ways[neighbour]) % MOD;   
                }
            }
        }
        return (int)ways[n-1];
    }
}