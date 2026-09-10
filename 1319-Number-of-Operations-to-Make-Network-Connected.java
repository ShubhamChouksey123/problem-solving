class Solution {

    private int[] parent;
    private int[] rank;
    private int connectedComponent; 

    private int find(int x){
        if(parent[x] == x){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private boolean union(int x, int y){

        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY){
            return false;
        }

        if(rank[rootX] > rank[rootY]){
            parent[rootY] = rootX;
        }
        else if(rank[rootX] < rank[rootY]){
            parent[rootX] = rootY;
        }
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        connectedComponent--;
        return true;
    }

    public int makeConnected(int n, int[][] connections) {

        parent = new int[n];
        rank = new int[n];
        connectedComponent = n;
        if(connections.length < n - 1) return -1;

        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] connection : connections){
            int u = connection[0];
            int v = connection[1];

            union(u, v);
        }


        return connectedComponent - 1;
        
    }
}