1class Solution {
2
3    void print(boolean[] arr){
4        for(int i = 0 ; i < arr.length ; i++){
5            System.out.print(arr[i] + ", ");
6        }
7        System.out.println("");
8    }
9
10    private boolean isCycle(int[][] graph, boolean[] visited, boolean[] recStack, int node){
11
12        // cycle detected
13        if(recStack[node]){
14            return true;
15        } 
16
17        // if already visited and not in rec Stack then, no cycle.
18        if(visited[node]){
19            return false;
20        }
21
22        visited[node] = true;
23        recStack[node] = true;
24
25        for(int neighbour : graph[node]){
26            if(isCycle(graph, visited, recStack, neighbour)){
27                return true;
28            }
29        
30        }
31        recStack[node] = false;
32        return false;
33    }
34
35    public List<Integer> eventualSafeNodes(int[][] graph) {
36
37        int n = graph.length;
38        boolean[] visited = new boolean[n];
39        boolean[] recStack = new boolean[n];
40
41        List<Integer> result = new ArrayList<>();
42
43        for(int i = 0 ; i < n ; i++){
44            boolean isCycle = isCycle(graph, visited, recStack, i);
45            if(!isCycle) result.add(i);
46        }
47
48        return result; 
49    }
50}