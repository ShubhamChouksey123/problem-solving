1class Solution {
2    public int[] findOrder(int numCourses, int[][] prerequisites) {
3        
4        List<Integer>[] adj = new ArrayList[numCourses];
5        for(int i = 0 ; i < numCourses ; i++){
6            adj[i] = new ArrayList<>();
7        }
8
9        int[] inwardEdges = new int[numCourses];
10        for(int[] prerequisite : prerequisites){
11            int u = prerequisite[1], v = prerequisite[0];
12            adj[u].add(v);
13            inwardEdges[v]++;
14        }
15
16        Deque<Integer> queue = new ArrayDeque<>();
17        for(int i = 0 ; i < numCourses ; i++){
18            if(inwardEdges[i] == 0){
19                queue.offerLast(i);
20            }
21        }
22
23        List<Integer> ans = new ArrayList<>();
24        while(!queue.isEmpty()){
25            int node = queue.pollFirst();
26            ans.add(node);
27
28            for(int neighbour : adj[node]){
29                if(--inwardEdges[neighbour] == 0){
30                    queue.offerLast(neighbour);
31                }
32            }
33        }
34
35        if(ans.size() < numCourses) return new int[0];
36
37        int[] list = new int[numCourses];
38        for(int i = 0; i < numCourses ; i++){
39            list[i] = ans.get(i);
40        }
41        return list;
42    }
43}