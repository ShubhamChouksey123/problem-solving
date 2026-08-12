class Solution {

    private int[] parent;
    private int[] rank;
    private int totalComponents;

    private int find(int x){
        if(parent[x] != x){
            return find(parent[x]);
        }
        return parent[x];
    }

    private boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY) return false;

        if(rank[rootX] > rank[rootY]){
            parent[rootY] = rootX;
        }
        else if(rank[rootX] < rank[rootY]){
            parent[rootX] = rootY;
        }
        else{
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        totalComponents--;
        return true;
    }

    public int minCost(int n, int[][] edges, int k) {
        parent = new int[n];
        rank = new int[n];

        totalComponents = n;
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int maxEdgeWeightUsed = 0;
        for(int[] edge : edges){
            if(totalComponents > k){
                union(edge[0], edge[1]);
                maxEdgeWeightUsed = edge[2];
            }
        }
        return maxEdgeWeightUsed;
    }
}