1class Solution {
2
3    /**
4        Using the modified Dijkstra's Algorithm for finding shortest path in DAG
5
6    
7     */
8    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
9
10
11        // Adjacency list containing neigbour and its edge weight
12        List<int[]>[] adj = new ArrayList[n];
13        for(int i = 0 ; i < n ; i++){
14            adj[i] = new ArrayList<>();
15        }
16
17        for(int i = 0 ; i < flights.length ; i++){
18            int u = flights[i][0], v = flights[i][1], w = flights[i][2];
19            adj[u].add(new int[]{v, w});
20        }
21
22        int[] dist = new int[n];
23        Arrays.fill(dist, Integer.MAX_VALUE);
24        dist[src] = 0;
25        
26
27        // Priority Queue containe {node, distance(price)}
28        Deque<int[]> pq = new ArrayDeque<>();
29        pq.offer(new int[]{src, 0});
30        int stop = 0;
31
32        while(!pq.isEmpty()){
33            
34            if(stop > k) break;
35
36            int size = pq.size();
37            for(int i = 0 ; i < size ; i++){
38
39                int[] curr = pq.poll();
40                int node = curr[0], curDist = curr[1];
41
42                for(int[] neighbourWeightArray : adj[node]){
43                    int neighbourNode = neighbourWeightArray[0];
44                    int neighbourWeight = neighbourWeightArray[1];
45                    int newWeight = curDist + neighbourWeight;
46
47                    if(newWeight < dist[neighbourNode]){
48                        dist[neighbourNode] = newWeight;
49                        pq.offer(new int[]{neighbourNode, newWeight});
50                    }
51                }
52            }
53            stop++;
54        }
55        if(dist[dst] == Integer.MAX_VALUE) return -1;
56        return dist[dst];
57    }
58}