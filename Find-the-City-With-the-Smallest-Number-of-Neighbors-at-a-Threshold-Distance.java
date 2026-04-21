1class Solution {
2    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
3
4        int[][] distance = new int[n][n];
5        for(int[] d: distance){
6            Arrays.fill(d, Integer.MAX_VALUE);
7        }
8        for(int[] edge : edges){
9            int u = edge[0], v = edge[1], w = edge[2];
10            distance[u][v] = w;
11            distance[v][u] = w;
12        }
13
14        for(int k = 0 ; k < n ; k++){
15            for(int i = 0 ; i < n ; i++){
16                for(int j = 0 ; j < n ; j++){
17                    if(distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE
18                        && distance[i][k] + distance[k][j] < distance[i][j]
19                    ){
20                        distance[i][j] = distance[i][k] + distance[k][j]; 
21                    }
22                }
23            }
24        }
25
26        int smallestReachableCityCount = Integer.MAX_VALUE;
27        int smallestReachableCityIndex = 0;
28        for(int i = 0 ; i < n ; i++){
29            int countReachableCities = 0;
30            for(int j = 0 ; j < n ; j++){
31                if(i != j && distance[i][j] <= distanceThreshold){
32                    countReachableCities++;
33                }
34            }
35            if(countReachableCities <= smallestReachableCityCount){
36                smallestReachableCityCount = countReachableCities;
37                smallestReachableCityIndex = i;
38            }
39        }
40        return smallestReachableCityIndex;
41        
42    }
43}