1class Solution {
2
3    /**
4        BFS using Kahn's Algorithm
5     */
6    public int[] findOrder(int numCourses, int[][] prerequisites) {
7        List<List<Integer>> adj = new ArrayList<>(numCourses);
8        for(int i = 0 ; i < numCourses ; i++){
9            adj.add(new ArrayList<>());
10        }
11
12        int[] inwardEdgeCount = new int[numCourses];
13        for(int[] prerequisite : prerequisites){
14            int u = prerequisite[1];
15            int v = prerequisite[0];
16            adj.get(u).add(v);
17            inwardEdgeCount[v]++;
18        }
19
20        Deque<Integer> queue = new ArrayDeque<>();
21        int[] ans = new int[numCourses];
22        int indexAtAns = 0;
23
24        for(int i = 0 ; i < numCourses ; i++){
25            if(inwardEdgeCount[i] == 0){
26                queue.offerLast(i);
27            }
28        }
29        
30
31        while(!queue.isEmpty()){
32            int course = queue.pollFirst();
33            ans[indexAtAns++] = course;
34
35            for(int neighbour : adj.get(course)){
36                if(--inwardEdgeCount[neighbour] == 0){
37                    queue.offerLast(neighbour);
38                }
39            }
40        }
41
42        if(indexAtAns != numCourses){
43            return new int[0];
44        }
45
46        return ans;
47    }
48}