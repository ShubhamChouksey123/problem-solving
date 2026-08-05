class Solution {
    
    
    private void dfs(List<Integer>[] adj, boolean[] suspicious, int node) {
        
        suspicious[node] = true;

        for(int neighbour : adj[node]){
            if(!suspicious[neighbour]){
                dfs(adj, suspicious, neighbour);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] invocation : invocations){
            adj[invocation[0]].add(invocation[1]);
        }
        boolean[] suspicious = new boolean[n]; 
        dfs(adj, suspicious, k);

        boolean canRemoveAll = true;
        for(int[] invocation : invocations){
            int u = invocation[0], v = invocation[1];
            if(!suspicious[u] && suspicious[v]){
                canRemoveAll = false; break;
            }
        }

        List<Integer> ans = new ArrayList<>();
        if(!canRemoveAll) {
            for(int i = 0 ; i < n ; i++){
                ans.add(i);
            }
        }
        else{
            for(int i = 0 ; i < n ; i++){
                if(!suspicious[i]) ans.add(i);
            }
        }
        return ans;
    }
}