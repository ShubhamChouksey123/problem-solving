1class Solution {
2    public int networkDelayTime(int[][] times, int n, int k) {
3        
4        k = k-1;
5        List<List<List<Integer>>> adj = new ArrayList<>(n);
6        for(int i = 0 ; i < n ; i++){
7            adj.add(new ArrayList<>());
8        }
9
10        for(int[] time : times){
11            int u = time[0] - 1, v = time[1] - 1, w = time[2];
12            adj.get(u).add(List.of(v, w));
13        }
14        
15        boolean[] visited = new boolean[n];
16        int[] dist = new int[n];
17        Arrays.fill(dist, Integer.MAX_VALUE);
18        dist[k] = 0;
19
20        /**
21            queue containg (distance , nodeIndex)
22         */
23        Queue<int[]> queue = new PriorityQueue<>(
24            (int[] a, int[] b) -> {
25                if(a[0] == b[0]){
26                    return Integer.compare(a[1], b[1]);
27                }
28                return Integer.compare(a[0], b[0]);
29            }
30        );
31
32        queue.add(new int[]{0 , k});
33        Set<Integer> unvisitedNodes = new HashSet<>();
34
35        int curDistance = 0; int nodeIndex = k;
36
37        while(!queue.isEmpty()){
38            int[] cur = queue.poll();
39            nodeIndex = cur[1];
40            curDistance = cur[0]; 
41
42            if(curDistance > dist[nodeIndex]) continue;
43
44            visited[nodeIndex] = true;
45
46
47            for(List<Integer> neighbourInfo : adj.get(nodeIndex)){
48                int neighbourIndex = neighbourInfo.get(0);
49                int weight = neighbourInfo.get(1);
50
51                if(!visited[neighbourIndex] && dist[nodeIndex] + weight < dist[neighbourIndex]){
52                    dist[neighbourIndex] = dist[nodeIndex] + weight;
53                    queue.add(new int[]{dist[neighbourIndex], neighbourIndex});
54                }
55            } 
56 
57        }
58
59        int maxValue = 0;
60        for(int d : dist){
61            if(d == Integer.MAX_VALUE) return -1;
62            maxValue = Math.max(maxValue, d);
63        }
64        return maxValue;
65    }
66}