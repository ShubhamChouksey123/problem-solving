class Solution {

    private int findParent(int a, int[] parents){

        if(parents[a] != a){
            parents[a] = findParent(parents[a], parents);
        }
        return parents[a];
    }

    private void unionGroups(int a, int b, int[] parents, int[] ranks){

        int aParent = findParent(a, parents);
        int bParent = findParent(b, parents);
        
        if(aParent == bParent){
            return;
        }

        if(ranks[aParent] < ranks[bParent]){
            parents[aParent] = bParent;
        }
        else if(ranks[aParent] > ranks[bParent]){
            parents[bParent] = aParent;
        }
        else{
            parents[aParent] = bParent;
            ranks[bParent]++;
        }
    }

    private boolean isConnected(int a, int b, int[] parents, int[] ranks){

        int aParent = findParent(a, parents);
        int bParent = findParent(b, parents);
        
        if(aParent == bParent){
            return true;
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int[] ranks = new int[n+1];
        int[] parents = new int[n+1];

        for(int i = 1; i <= n ; i++){
            ranks[i] = 1;
            parents[i] = i;
        }

        int[] ans = new int[2];
        int count = 0;
        for(int[] edge : edges){
            if(isConnected(edge[0], edge[1], parents, ranks)){
                count++; ans[0] = edge[0]; ans[1] = edge[1];
            }else{
                unionGroups(edge[0], edge[1], parents, ranks);
            }
        }

        return ans;
    }
}