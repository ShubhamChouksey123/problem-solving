class Solution {

    private final int MOD = 1_000_000_007;

    private int dfs(List<int[]>[] adj, int[] memoCache, int[] minDistance, int node, int maxAllowedValue){

        if(minDistance[node] >= maxAllowedValue) return 0;
        if(node == adj.length - 1) return 1;
        if(memoCache[node] != -1) return memoCache[node];

        int paths = 0;
        int nextMaxAllowedValue = minDistance[node];
        for(int[] neighbourEdge : adj[node]){
            int neighbour = neighbourEdge[0];
            paths = (paths + dfs(adj, memoCache, minDistance, neighbour, nextMaxAllowedValue)) % MOD;
        }
        memoCache[node] = paths;
        return paths;
    }

    public int countRestrictedPaths(int n, int[][] edges) {
        
        // adjacency list containing node -> [{neighbour_node, edge}, {}]
        List<int[]>[] adj = new ArrayList[n];

        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0] - 1, v = edge[1] - 1, w = edge[2]; 
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }
        
        int[] minDistance = new int[n];
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        // queue contiaing (node, distance)
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{n - 1, 0});
        minDistance[n - 1] = 0;

    
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int node = top[0], distance = top[1];

            if(minDistance[node] < distance) continue;

            for(int[] neighbourEdge : adj[node]){
                int neighbour = neighbourEdge[0];
                int curDist = distance + neighbourEdge[1];
                if(minDistance[neighbour] > curDist){
                    minDistance[neighbour] = curDist;
                    pq.add(new int[]{neighbour, curDist});
                }
            }
        }

        int[] memoCache = new int[n];
        Arrays.fill(memoCache, -1);

        int paths = dfs(adj, memoCache, minDistance, 0, Integer.MAX_VALUE);
        return paths;
    }


}