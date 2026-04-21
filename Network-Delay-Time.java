1class Solution {
2
3    /**
4        use bellman ford Algorithm to solve this shortest distance problem
5     */
6    public int networkDelayTime(int[][] times, int n, int k) {
7
8        int iterations = n - 1;
9        int[] dist = new int[n];
10        Arrays.fill(dist, Integer.MAX_VALUE);
11        dist[k-1] = 0;
12        
13        while(iterations > 0){
14            iterations--;
15            boolean changed = false;
16            for(int[] time : times){
17                int u = time[0] - 1, v = time[1] - 1, w = time[2];
18                if(dist[u] != Integer.MAX_VALUE){
19                    int newDistance = dist[u] + w;
20                    if(dist[v] > newDistance){
21                        dist[v] = newDistance;
22                        changed = true;
23                    }  
24                }
25                
26            }
27            if(!changed){
28                break;
29            }
30        }
31
32        int maxValue = 0;
33        for(int i = 0 ; i < n ; i++){
34            if(i == k - 1) continue;
35            maxValue = Math.max(maxValue, dist[i]);
36        }
37        return (maxValue == Integer.MAX_VALUE) ? -1 : maxValue;
38        
39    }
40}