1class Solution {
2
3    private boolean isPathExists(int n, List<List<Integer>> adj, boolean[] visited, int destination, int node){
4
5        if(destination == node){
6            return true;
7        }
8        visited[node] = true;
9
10        for(int neighbour : adj.get(node)){
11            if(!visited[neighbour]){
12                if(isPathExists(n, adj, visited, destination, neighbour)){
13                    return true;
14                }
15            }
16        }
17        return false;
18    }
19
20    /**
21        check a path exists or not via DFS
22     */
23    public boolean validPath(int n, int[][] edges, int source, int destination) {
24        List<List<Integer>> adj = new ArrayList<>();
25        for(int i = 0 ; i < n ; i++){
26            adj.add(new ArrayList<>());
27        }
28        for(int[] edge : edges){
29            int u = edge[0], v = edge[1];
30            adj.get(u).add(v);
31            adj.get(v).add(u);
32        }   
33
34        boolean[] visited = new boolean[n];
35
36        return isPathExists(n, adj, visited, destination, source); 
37    }
38}