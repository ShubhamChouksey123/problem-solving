class Solution {

    private int findParent(int a, int[] parents){
        if(parents[a] != a){
            parents[a] = findParent(parents[a], parents);
        }
        return parents[a];
    }

    private void union(int a, int b, int[] parents, int[] ranks){
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

    private boolean isConnected(int a, int b, int[] parents){
        int aParent = findParent(a, parents);
        int bParent = findParent(b, parents);

        if(aParent == bParent){
            return true;
        }
        return false;
    }


    public int maxNumEdgesToRemove(int n, int[][] edges) {

        int[] parentsAice = new int[n+1];
        int[] parentsBob = new int[n+1];
        int[] ranksAice = new int[n+1];
        int[] ranksBob = new int[n+1];

        for(int i = 1 ; i <= n ; i++){
            parentsAice[i] = i;
            ranksAice[i] = 1;
            parentsBob[i] = i;
            ranksBob[i] = 1;
        }

        int needed = 0;
        
        for(int i = 0 ; i < edges.length ; i++){
            int type = edges[i][0];
            int a = edges[i][1], b = edges[i][2];
            if(type == 3){
                if(!isConnected(a, b, parentsAice)){
                    needed++;
                    union(a, b, parentsAice, ranksAice);
                    union(a, b, parentsBob, ranksBob);
                }
                else if(!isConnected(a, b, parentsBob)){
                    needed++;
                    union(a, b, parentsAice, ranksAice);
                    union(a, b, parentsBob, ranksBob);
                }
            }
        } 
        
        for(int i = 0 ; i < edges.length ; i++){
            int type = edges[i][0];
            int a = edges[i][1], b = edges[i][2];
            if(type == 1){
                if(!isConnected(a, b, parentsAice)){
                    needed++;
                    union(a, b, parentsAice, ranksAice);
                }
            }
            else if(type == 2){
                if(!isConnected(a, b, parentsBob)){
                    needed++;
                    union(a, b, parentsBob, ranksBob);
                }
            }
        }   

        for(int i = 1 ; i <= n ; i++){
            parentsAice[i] = findParent(i, parentsAice);
            parentsBob[i] = findParent(i, parentsBob);
        }

        Set<Integer> leadersAlice = new HashSet<>();
        Set<Integer> leadersBob = new HashSet<>();
        for(int i = 1 ; i <= n ; i++){
            leadersAlice.add(parentsAice[i]);
            leadersBob.add(parentsBob[i]);
        }

        if(leadersAlice.size() > 1 || leadersBob.size() > 1){
            return -1;
        }
        
        return edges.length - needed;
    }
}