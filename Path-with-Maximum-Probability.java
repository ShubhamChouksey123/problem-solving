1class Solution {
2    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
3
4
5        List<double[]>[] adj = new ArrayList[n];
6        for(int i = 0 ; i < n ; i++){
7            adj[i] = new ArrayList<>();
8        }
9        for(int i = 0 ; i < edges.length ; i++){
10            int u = edges[i][0], v = edges[i][1];
11            double w = succProb[i];
12            adj[u].add(new double[]{Double.valueOf(v), w} );
13            adj[v].add(new double[]{Double.valueOf(u), w} );
14        }
15
16        double[] dist = new double[n];
17        Arrays.fill(dist, 0.0);
18        dist[start_node] = 1.0;
19
20        // Max Priority Queue containing node and its probability
21        Queue<double[]> queue = new PriorityQueue<>(
22            (a, b) -> {
23                return Double.compare(b[1], a[1]);
24            }
25        );
26        queue.add(new double[]{start_node, 1});
27
28        while(!queue.isEmpty()){
29            double[] curr = queue.poll();
30            int node = (int)curr[0];
31            double p = curr[1];
32            
33            if(p < dist[node]) {
34                continue;
35            }    
36
37            for(double[] neighbourNode : adj[node]){
38                double newProbability = p * neighbourNode[1];
39                int neighbourNodeIndex = (int) neighbourNode[0];
40
41                
42                if(newProbability > dist[neighbourNodeIndex]){
43                    dist[neighbourNodeIndex] = newProbability;
44                    queue.add(new double[]{neighbourNodeIndex, newProbability});
45                }
46            }
47        }
48        return dist[end_node];
49    }
50}