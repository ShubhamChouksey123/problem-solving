1class Solution {
2    private int timer;
3
4    private void dfs(int n, List<Integer>[] adj, int[] dis, int[] low, List<List<Integer>> bridges, boolean[] visited, int u, int parent){
5
6        dis[u] = low[u] = timer++;
7        visited[u] = true;
8
9        for(int v : adj[u]){
10            if(v == parent) continue;
11            if(!visited[v]){
12                dfs(n, adj, dis, low, bridges, visited, v, u);
13                low[u] = Math.min(low[u], low[v]);
14                if(low[v] > dis[u]){
15                    // condition for bridge
16                    bridges.add(List.of(u, v));       
17                }
18            }
19            else{
20                // loop detected 
21                low[u] = Math.min(low[u], dis[v]);    
22            }
23        }
24    }
25    
26    
27    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
28
29        int[] dis = new int[n];
30        int[] low = new int[n];
31        Arrays.fill(dis, -1);
32        Arrays.fill(low, -1);
33        timer = 0;
34
35        List<Integer>[] adj = new ArrayList[n];
36        for(int i = 0 ; i < n ; i++){
37            adj[i] = new ArrayList<>();
38        }
39
40        for(int i = 0 ; i < connections.size() ; i++){
41            int u = connections.get(i).get(0), v = connections.get(i).get(1);
42            adj[u].add(v);
43            adj[v].add(u);
44        }
45
46        List<List<Integer>> bridges = new ArrayList<>(); 
47        boolean[] visited = new boolean[n];
48
49
50        dfs(n, adj, dis, low, bridges, visited, 0, -1);
51        return bridges;
52    }
53}