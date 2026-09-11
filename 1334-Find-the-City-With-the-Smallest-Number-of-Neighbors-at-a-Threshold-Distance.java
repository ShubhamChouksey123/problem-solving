class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] minDistance = new int[n][n];
        for(int[] row : minDistance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for(int i = 0 ; i < n ; i++){
            minDistance[i][i] = 0;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            minDistance[u][v] = w;
            minDistance[v][u] = w;
        }

        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(minDistance[i][k] != Integer.MAX_VALUE &&
                        minDistance[k][j] != Integer.MAX_VALUE &&
                        minDistance[i][k] + minDistance[k][j] < minDistance[i][j])
                    {
                        minDistance[i][j] = minDistance[i][k] + minDistance[k][j];
                    }
                }
            }
        }


        int[] reachanleByCitiesCount = new int[n];
        int minReachbleCitiesCount = Integer.MAX_VALUE;
        int minReachbleCity = -1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(minDistance[i][j] <= distanceThreshold){
                    reachanleByCitiesCount[i]++;
                }
            }
            if(reachanleByCitiesCount[i] <= minReachbleCitiesCount){
                minReachbleCitiesCount = reachanleByCitiesCount[i];
                minReachbleCity = i;
            }
        }

        return minReachbleCity;
    }
}