class Solution {
    public int minCost(int n, int[][] edges) {
        
        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0], v = edge[1], w = edge[2];
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, 2 * w});
        }

        int[] minDistance = new int[n];
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        // priority queue containing {node, cost}
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        minDistance[0] = 0;
        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()){

            int[] top = queue.poll();
            int node = top[0], distance = top[1];

            if(minDistance[node] < distance) continue;
            if(node == n - 1) return distance;

            for(int[] neighbourEdge : adj[node]){
                int neighbour = neighbourEdge[0];
                int thisCost = distance + neighbourEdge[1];

                if(minDistance[neighbour] > thisCost){
                    minDistance[neighbour] = thisCost;
                    queue.add(new int[]{neighbour, thisCost});
                }
            }
        }
        return -1;
    }
}