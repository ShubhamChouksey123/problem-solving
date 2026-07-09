class Solution {

    private int[] parent;
    private int[] rank;

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
        else if(rank[rootX] < rank[rootY]){
            parent[rootX] = rootY;
        }
        else{
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;

    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }

        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
            rank[i] = 1;
        }


        for(int i = 1 ; i < nums.length ; i++){
            if(Math.abs(nums[i] - nums[i-1]) <= maxDiff){
                union(i, i-1);
            }
        }

        int totalQueries = queries.length ;
        boolean[] ans = new boolean[totalQueries];

        for(int i = 0 ; i < totalQueries ; i++){
            int rootX = find(queries[i][0]);
            int rootY = find(queries[i][1]);

            if(rootX == rootY){
                ans[i] = true;
            }
        }
        
        return ans;
    }
}