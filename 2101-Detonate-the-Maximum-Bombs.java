class Solution {

    private boolean liesInRange(int[] bomb1, int[] bomb2){
        
        long dx = (long)bomb1[0] - bomb2[0];
        long dy = (long)bomb1[1] - bomb2[1];
        long r1 = bomb1[2];

        return (dx * dx + dy * dy) <= (r1 * r1); 
    }

    private int dfs(List<Integer>[] adj, boolean[] visited, int node){

        if(visited[node]) return 0;
        visited[node] = true;
        
        int count = 1;
        for(int neighbour : adj[node]){
            if(visited[neighbour]) continue;

            count += dfs(adj, visited, neighbour);
        }
        return count;
    }

    public int maximumDetonation(int[][] bombs) {

        int n = bombs.length;
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j) continue;
                if(liesInRange(bombs[i], bombs[j])){
                    adj[i].add(j);
                }   
            }
        }
        

        int maxCount = 0;
        for(int i = 0 ; i < n ; i++){
            boolean[] visited = new boolean[n]; 
            int count = dfs(adj, visited, i); 
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}