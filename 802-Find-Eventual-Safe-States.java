class Solution {
    
    public boolean isSafeNode(int[][] adj, List<Integer> ans, int[] visited, boolean[] isSafeNode, int start) {
        
        if(visited[start] == 1) return false;
        if(visited[start] == 2) {
            return isSafeNode[start];
        }

        visited[start] = 1;

        boolean isSafe = true;
        for(int neighbour : adj[start]){
            if(!isSafeNode(adj, ans, visited, isSafeNode, neighbour)){
                isSafe = false;
            }
        }
        visited[start] = 2;
        isSafeNode[start] = isSafe;
        if(isSafe) ans.add(start);
        return isSafe;
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;
        /**
            0 => unvisited, 1 => visisting, and 2 => visisted
         */
        int[] visited = new int[n];
        boolean[] isSafeNode = new boolean[n];
        Arrays.fill(visited, 0);

        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            if(visited[i] == 0){
                isSafeNode(graph, ans, visited, isSafeNode, i); 
            }
        }
        Collections.sort(ans);
        return ans;
    }
}