class Solution {

    private int[] parent;
    private int[] rank;

    private int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private boolean union(int x , int y){

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
        return true;
    }

    public int countCompleteComponents(int n, int[][] edges) {

        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges){
            union(edge[0], edge[1]);
        }

        Map<Integer, Integer> rootToComponentSize = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            int root = find(i);
            rootToComponentSize.put(root, rootToComponentSize.getOrDefault(root, 0) + 1);
        }

        Map<Integer, Integer> rootToTotalEdges = new HashMap<>();
        for(int[] edge : edges){
            int root = find(edge[0]);
            rootToTotalEdges.put(root, rootToTotalEdges.getOrDefault(root, 0) + 1);
        }

        int count = 0;
        for(Map.Entry<Integer, Integer> entry : rootToComponentSize.entrySet()){
            int root = entry.getKey();
            int totalNodesInComponent = entry.getValue();
            int totalEdgesInComponent = rootToTotalEdges.getOrDefault(root, 0);

            if(totalEdgesInComponent == (totalNodesInComponent * (totalNodesInComponent - 1) )/2 ) count++;
        }

        return count;   
    }
}