class Solution {

    private boolean dfs(int[][] graph, boolean[] visited, boolean[] isTerminalNode, boolean[] inStack, int node){

        if(inStack[node]) {
            return false;
        }
        if(visited[node]) return isTerminalNode[node];

        inStack[node] = true;

        for(int neighbour : graph[node]){
            if(!dfs(graph, visited, isTerminalNode, inStack, neighbour)){
                isTerminalNode[node] = false;
                return false;
            }
        }        

        inStack[node] = false;
        isTerminalNode[node] = true;
        visited[node] = true;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] isTerminalNode = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]) {
                boolean[] inStack = new boolean[n];
                dfs(graph, visited, isTerminalNode, inStack, i);
            }
        }
        
        List<Integer> terminalNodes = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(isTerminalNode[i]) terminalNodes.add(i);
        }
        return terminalNodes;
    }
}