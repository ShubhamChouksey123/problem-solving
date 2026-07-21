class Solution {

    private int id;

    // assign compoenent Id to elements
    private void dfs(List<Integer>[] adj, int[] idTocomponentId, int idToAssign, int node){

        idTocomponentId[node] = idToAssign;
        
        for(int neighbour : adj[node]){
            if(idTocomponentId[neighbour] == -1){
                dfs(adj, idTocomponentId, idToAssign, neighbour);
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        id = 0;

        List<Integer>[] adj = new ArrayList[c];
        for(int i = 0 ; i < c ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] connection : connections){
            adj[connection[0] - 1].add(connection[1] - 1);
            adj[connection[1] - 1].add(connection[0] - 1);
        }

        int[] idTocomponentId = new int[c];
        Arrays.fill(idTocomponentId, -1);
        for(int i = 0 ; i < c ; i++){
            if(idTocomponentId[i] == -1){
                dfs(adj, idTocomponentId, id++, i);
            }
        }

        int idMax = id;
        TreeSet<Integer>[] componentIdToELements = new TreeSet[idMax];
        for(int i = 0 ; i < idMax ; i++){
            componentIdToELements[i] = new TreeSet<>();
        }

        for(int i = 0 ; i < c ; i++){
            int compId = idTocomponentId[i];
            componentIdToELements[compId].add(i);
        }

        int queryLength = queries.length;
        int ansLength = 0;

        for(int i = 0 ; i < queryLength ; i++){
            if(queries[i][0] == 1){
                ansLength++;
            }
        }
        int[] ans = new int[ansLength];

        int idx = 0;
        for(int i = 0 ; i < queryLength ; i++){
            int node = queries[i][1] - 1; 
            int compId = idTocomponentId[node];
            TreeSet<Integer> st = componentIdToELements[compId];
            if(queries[i][0] == 1){ 
                if(st.contains(node)) {
                    ans[idx++] = node + 1;
                }
                else{
                    ans[idx++] = (st.size() > 0) ? st.first() + 1 : -1;
                }
            }
            else {
                // 2 operation
                componentIdToELements[compId].remove(node);      
            }
        }
        return ans;
    }
}