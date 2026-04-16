1class Solution {
2
3    private int N;
4    
5    private boolean isSafeNode(int[][] graph, boolean[] visited, int[] isSafeNode, int nodeIndex){
6        
7        if(isSafeNode[nodeIndex] != -1){
8            return isSafeNode[nodeIndex] == 1;
9        }
10
11        if(visited[nodeIndex]){
12            isSafeNode[nodeIndex] = 0;
13            return false;
14        }
15
16        visited[nodeIndex] = true;
17        boolean isSafe = true;
18        if(graph[nodeIndex].length == 0){
19            isSafe = true;
20        }
21
22        
23        for(int neighbourIndex : graph[nodeIndex]){
24            if(!isSafeNode(graph, visited, isSafeNode, neighbourIndex)){
25                isSafe = false;
26            }
27        }
28        visited[nodeIndex] = false;
29        isSafeNode[nodeIndex] = (isSafe == true) ? 1 : 0; 
30        return isSafe;
31    }
32    
33    public List<Integer> eventualSafeNodes(int[][] graph) {
34        N = graph.length;
35        boolean[] visited = new boolean[N];
36
37        /**
38            -1 not sure
39            0 => not safe
40            1 => safe
41         */
42        int[] isSafeNode = new int[N];
43        Arrays.fill(isSafeNode, -1);
44
45        for(int i = 0 ; i < N ; i++){
46            if(isSafeNode[i] == -1){
47                isSafeNode(graph, visited, isSafeNode, i);
48            }
49        }
50
51        List<Integer> ans = new ArrayList<>();
52        for(int i = 0 ; i < N ; i++){
53            if(isSafeNode[i] == 1){
54                ans.add(i);
55            }
56        }
57
58        
59        return ans; 
60
61        
62    }
63}