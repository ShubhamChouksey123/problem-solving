1class Solution {
2    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
3
4
5        // Adjacency list containing neigbour and its edge weight
6        List<int[]>[] adj = new ArrayList[n];
7        for(int i = 0 ; i < n ; i++){
8            adj[i] = new ArrayList<>();
9        }
10
11        for(int i = 0 ; i < flights.length ; i++){
12            int u = flights[i][0], v = flights[i][1], w = flights[i][2];
13            adj[u].add(new int[]{v, w});
14            // adj[v].add(new int[]{u, w});
15        }
16
17        int[] dist = new int[n];
18        Arrays.fill(dist, Integer.MAX_VALUE);
19        dist[src] = 0;
20        
21
22        // Priority Queue containe {step, node, distance}
23        Queue<int[]> pq = new PriorityQueue<>(
24            (a, b)  -> Integer.compare(a[0], b[0])
25        );
26
27        pq.offer(new int[]{0, src, 0});
28
29        while(!pq.isEmpty()){
30            int[] curr = pq.poll();
31            int node = curr[1];
32            int step = curr[0], curDist = curr[2];
33            // System.out.println("step : " + step + ", node : " + node + ", curDist : " + curDist);
34            // System.out.println("dist : " + Arrays.toString(dist) );
35
36            if(node == dst) continue;
37
38
39            for(int[] nodeEdgeWeight : adj[node]){
40                int newWeight = curDist + nodeEdgeWeight[1];
41                int newStep = step + 1;
42                int neighbourNode = nodeEdgeWeight[0];
43                
44                if(newStep == k + 1 && neighbourNode != dst) continue;
45
46                if(newWeight < dist[neighbourNode]){
47                    dist[neighbourNode] = newWeight;
48                    pq.add(new int[]{newStep, neighbourNode, newWeight});
49                }
50                
51            }
52        }
53        return dist[dst] != Integer.MAX_VALUE ? dist[dst] : -1;
54    }
55}