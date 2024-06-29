class Solution {

    private void dfs(int[][] isConnected, int n, boolean[] visited, int vertex) {
        
        for(int j = 0 ; j < n ; j++){
            if(!visited[j] && isConnected[vertex][j] == 1){
                visited[j] = true;
                dfs(isConnected, n, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int provinces = 0;
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                provinces++;
                visited[i] = true;
                dfs(isConnected, n, visited, i);
            }
        } 
        return provinces;
    }
}