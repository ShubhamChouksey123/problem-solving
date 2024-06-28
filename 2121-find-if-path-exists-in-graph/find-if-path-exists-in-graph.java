class Solution {

    private boolean isPathExists(List<List<Integer>> graph, boolean[] visited, int current, int destination) {
        
        if(current == destination){
            return true;
        }
        
        visited[current] = true;

        for(Integer neighbour : graph.get(current)){
            if(!visited[neighbour]){
                if(isPathExists(graph, visited, neighbour, destination)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private void createGraph(int n, int[][] edges, List<List<Integer>> graph) {

        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        List<List<Integer>> graph = new ArrayList<>();
        createGraph(n, edges, graph);

        boolean[] visited = new boolean[n];
        if(isPathExists(graph, visited, source, destination)){
            return true;
        }
        return false;
    }
}