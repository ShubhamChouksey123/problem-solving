class Solution {
    
    private int[] parent;
    private int[] rank;
    private int connectedComponents;

    private int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
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
        if(rank[rootX] < rank[rootY]){
            parent[rootX] = rootY;
        }
        else{
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        connectedComponents--;
        return true;
    }

    public int makeConnected(int n, int[][] connections) {

        connectedComponents = n;
        parent = new int[n];
        rank = new int[n];

        if(connections.length < n - 1) return -1;
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] connection : connections){
            union(connection[0], connection[1]);
        }
        
        return connectedComponents - 1;
    }
}