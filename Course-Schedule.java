1class Solution {
2
3    /**
4        We will use the kahn'a Algorithm
5     */
6    public boolean canFinish(int numCourses, int[][] prerequisites) {
7
8        List<List<Integer>> adj = new ArrayList<>(numCourses);
9        for(int i = 0 ; i < numCourses ; i++){
10            adj.add(new ArrayList<>());
11        }
12
13        int[] countOutwardEdges = new int[numCourses];
14        for(int i = 0; i < prerequisites.length ; i++){
15            int[] prerequisite = prerequisites[i];
16            int u = prerequisite[1]; int v = prerequisite[0];
17            adj.get(u).add(v);
18            countOutwardEdges[v]++;
19        }
20        System.out.println("adj : " + adj);
21        
22        Deque<Integer> queue = new ArrayDeque<>();
23        for(int i = 0 ; i < numCourses ; i++){
24            if(countOutwardEdges[i] == 0){
25                queue.offerLast(i);
26            }
27        }
28        if(queue.isEmpty()){
29            return false;
30        }
31        boolean[] added = new boolean[numCourses];
32
33        while(!queue.isEmpty()){
34            int node = queue.pollFirst();
35            added[node] = true;
36            System.out.println("Added node : " + node);
37            for(int neighbour : adj.get(node)){
38                if(added[neighbour]){
39                    return false;
40                }
41                if(--countOutwardEdges[neighbour] == 0){
42                    queue.offerLast(neighbour);
43                }
44            }
45        }
46
47        for(int i = 0 ; i < numCourses ; i++){
48            if(!added[i]){
49                return false;
50            }
51        }
52
53        return true;
54
55    }
56}