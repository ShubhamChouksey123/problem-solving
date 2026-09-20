class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }
        
        int u = 0, v = 0, w = 0;
        for(int[] flight : flights){
            u = flight[0];
            v = flight[1];
            w = flight[2];
            adj[u].add(new int[]{v, w});
        }


        int[] minDistance = new int[n];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[src] = 0;
        /**
            queue containing (node, weight)
         */
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[]{src, 0});

        int stops = 0;
        while(!queue.isEmpty() && stops <= k){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                int[] top = queue.pollFirst();
                int node = top[0];
                int distance = top[1];
                
                for(int[] neighbourNodeInfo : adj[node]){
                    int neighbourNode = neighbourNodeInfo[0];
                    int newDisatnce = distance + neighbourNodeInfo[1];
                    if(newDisatnce < minDistance[neighbourNode]){
                        queue.add(new int[]{neighbourNode, newDisatnce});
                        minDistance[neighbourNode] = newDisatnce;
                    }
                }
            }
            stops++;
        }
        return minDistance[dst] == Integer.MAX_VALUE ? -1 : minDistance[dst];
    }
}