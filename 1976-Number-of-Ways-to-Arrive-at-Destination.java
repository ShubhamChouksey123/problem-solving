class Solution {

    private final long MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {

        List<long[]>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++) adj[i] = new ArrayList<>();
        
        for(int[] road : roads){
            adj[road[0]].add(new long[]{road[1], road[2]});
            adj[road[1]].add(new long[]{road[0], road[2]});
        }

        long[] minDistance = new long[n];
        Arrays.fill(minDistance, Long.MAX_VALUE);

        long[] paths = new long[n];

        // priority queue containing {node, cost}
        Queue<long[]> queue = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        minDistance[0] = 0;
        queue.add(new long[]{0, 0});
        paths[0] = 1;

        while(!queue.isEmpty()){
            long[] top = queue.poll();
            int node = (int)top[0]; long distance = top[1];

            if(minDistance[node] < distance) continue;

            for(long[] neighbourEdge : adj[node]){
                int neighbour = (int)neighbourEdge[0];
                long thisDistance = distance + neighbourEdge[1];

                if(minDistance[neighbour] == thisDistance){
                    paths[neighbour] = (paths[neighbour] + paths[node]) % MOD; 
                }
                else if(minDistance[neighbour] > thisDistance){
                    queue.add(new long[]{neighbour, thisDistance});
                    minDistance[neighbour] = thisDistance;
                    paths[neighbour] = paths[node]; 
                }
            }
        }
        return (int)paths[n-1];
    }
}