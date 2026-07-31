class TreeAncestor {

    private int[][] ithParent;

    public TreeAncestor(int n, int[] parent) {

        ithParent = new int[n][20];
        for(int[] row : ithParent){
            Arrays.fill(row, -1);
        }

        for(int i = 0 ; i < n ; i++){
            ithParent[i][0] = parent[i];
        }
        for(int j = 1 ; j < 20 ; j++){
            for(int i = 0 ; i < n ; i++){
                if(ithParent[i][j-1] != -1){
                    ithParent[i][j] = ithParent[ithParent[i][j-1]][j-1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        
        int currentNode = node;
        
        for(int i = 0 ; i < 20 && currentNode != -1 ; i++){
            if( ((k >> i) & 1 ) == 1){
                currentNode = ithParent[currentNode][i];
            }       
        }

        return currentNode;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */