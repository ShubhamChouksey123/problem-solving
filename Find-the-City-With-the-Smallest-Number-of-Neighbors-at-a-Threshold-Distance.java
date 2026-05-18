1class Solution {
2    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
3
4        int[][] dist = new int[n][n];
5
6        for(int i = 0 ; i < n ; i++){
7            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
8            dist[i][i] = 0;
9        }
10
11        for(int[] edge : edges){
12            int u = edge[0], v = edge[1], w = edge[2];
13            dist[u][v] = w;
14            dist[v][u] = w;
15        }
16
17        for(int k = 0 ; k < n ; k++){
18            for(int i = 0 ; i < n ; i++){
19                for(int j = 0 ; j < n ; j++){
20                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
21                }
22            }
23        }
24
25        int minCountCities = Integer.MAX_VALUE; int cityIndex = 0;
26        for(int i = 0 ; i < n ; i++){
27            int countCities = 0;
28            for(int j = 0 ; j < n ; j++){
29                if(i == j) continue;
30                if(dist[i][j] <= distanceThreshold) countCities++;
31            }
32            if(countCities <= minCountCities){
33                minCountCities = countCities; cityIndex = i;
34            }
35        }
36        return cityIndex;
37   
38    }
39}