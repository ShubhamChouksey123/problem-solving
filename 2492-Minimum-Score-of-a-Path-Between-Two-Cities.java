class Solution {
    
    private int dfs(int n, List<List<Integer>>[] adj, boolean[] visited, int node, int score){

        
        visited[node] = true;

        for(List<Integer> neighbourInfo : adj[node]){
            int neighbourNode = neighbourInfo.get(0);
            int dist = neighbourInfo.get(1);

            score = Math.min(score, dist);
            
            if(!visited[neighbourNode]){
                int innerScore = dfs(n, adj, visited, neighbourNode, score);
                score = Math.min(score, innerScore);
            }
            
        }

        return score;
    } 
    
    public int minScore(int n, int[][] roads) {

        List<List<Integer>>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] road : roads){
            int start = road[0] - 1, end = road[1] - 1, dist = road[2];
            adj[start].add(List.of(end, dist));
            adj[end].add(List.of(start, dist));
        }

        boolean[] visited = new boolean[n];

        int score = dfs(n, adj, visited, 0, Integer.MAX_VALUE);
        return score;
    }
}