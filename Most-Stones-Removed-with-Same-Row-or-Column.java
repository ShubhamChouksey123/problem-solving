1class Solution {
2
3    private void dfs(List<Integer>[] adj, boolean[] visited, int start){
4
5        visited[start] = true;
6
7        for(Integer neighbour : adj[start]){
8            if(!visited[neighbour]){
9                dfs(adj, visited, neighbour);
10            }
11        }
12    }
13
14
15    public int removeStones(int[][] stones) {
16        int n = stones.length;
17
18        List<Integer>[] adj = new ArrayList[n];
19        for(int i = 0 ; i < n ; i++){
20            adj[i] = new ArrayList<>();
21        }
22
23        for(int i = 0 ; i < n ; i++){
24            int row = stones[i][0], col = stones[i][1];
25            for(int j = i + 1 ; j < n ; j++){
26                if(i == j) continue;
27
28                if(row == stones[j][0] || col == stones[j][1]){
29                    adj[i].add(j);
30                    adj[j].add(i);
31                }
32            }    
33        } 
34
35        boolean[] visited = new boolean[n];
36        int connectedComponent = 0;
37
38        for(int i = 0; i < n ; i++){
39            if(!visited[i]){
40                connectedComponent++;
41                dfs(adj, visited, i);
42            }  
43        }   
44
45        return n - connectedComponent;
46    }
47}