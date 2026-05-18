1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3
4        int n = numCourses;
5        List<Integer>[] adj = new ArrayList[numCourses];
6        for(int i = 0 ; i < n ; i++){
7            adj[i]= new ArrayList<>();
8        }
9
10        int[] inwardEdges = new int[n];
11
12        for(int[] prerequisite : prerequisites){
13            int u = prerequisite[1], v = prerequisite[0];
14            adj[u].add(v);
15            inwardEdges[v]++;
16        }
17
18        Deque<Integer> queue = new ArrayDeque<>();
19        for(int i = 0 ; i < n ; i++){
20            if(inwardEdges[i] == 0){
21                queue.offerLast(i);
22            }
23        }
24
25        while(!queue.isEmpty()){
26            int node = queue.pollFirst();
27
28            for(int neighbour : adj[node]){
29                if(--inwardEdges[neighbour] == 0){
30                    queue.offerLast(neighbour);
31                }
32            }
33        }
34
35        for(int i = 0 ; i < n ; i++){
36            if(inwardEdges[i] > 0){
37               return false;
38            }
39        }
40        return true;
41
42
43    }
44}