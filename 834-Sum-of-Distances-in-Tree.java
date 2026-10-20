class Solution {

    private int[] ans;
    private int[] count;
    private int N;

    private void dfs1(List<Integer>[] adj, int node, int parent){
        for(int neighbour : adj[node]){
            if(neighbour == parent) continue;
            dfs1(adj, neighbour, node);
            count[node] += count[neighbour];
            ans[node] += (ans[neighbour] + count[neighbour]);
        }
    }

    private void dfs2(List<Integer>[] adj, int node, int parent){
        for(int neighbour : adj[node]){
            if(neighbour == parent) continue;
            ans[neighbour] = ans[node] - count[neighbour] + (N - count[neighbour]);
            dfs2(adj, neighbour, node);
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        N = n;
        List<Integer>[] adj = new ArrayList[n];
        this.ans = new int[n];
        this.count = new int[n];

        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
            count[i] = 1;
        }

        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        dfs1(adj, 0, -1);
        dfs2(adj, 0, -1);

        int[] dist = new int[n];
        return ans;
    }
}