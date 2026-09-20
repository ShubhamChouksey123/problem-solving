class Solution {
    public int findShortestCycle(int n, int[][] edges) {

        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        int minCycle = Integer.MAX_VALUE;


        for(int i = 0 ; i < n ; i++){
            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);

            Deque<Integer> queue = new ArrayDeque<>();
            distance[i] = 0;
            queue.offerLast(i);

            while(!queue.isEmpty()){

                int node = queue.pollFirst();

                for(int neighbour : adj[node]){
                    if(distance[neighbour] == Integer.MAX_VALUE){
                        distance[neighbour] = distance[node] + 1;
                        queue.offerLast(neighbour);
                    }
                    else if(distance[neighbour] >= distance[node]){
                        minCycle = Math.min(minCycle, distance[neighbour] + distance[node] + 1);
                    }
                }
            }
        }
        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
}