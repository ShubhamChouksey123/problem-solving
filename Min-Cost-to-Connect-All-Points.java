1class Solution {
2
3
4    private void addAllNeigbours(Queue<int[]> priorityQueue, boolean[] visited, int index, int[][] points){
5        
6        int x1 = points[index][0], y1 = points[index][1];
7        for(int j = 0 ; j < visited.length ; j++){
8            if( index != j && !visited[j]){
9                int x2 = points[j][0], y2 = points[j][1];
10                int w = Math.abs(x1 - x2) + Math.abs(y1 - y2);
11                priorityQueue.add(new int[]{index, j, w});
12            }
13        }
14    }
15
16    /**
17        Prim's Algorithm 
18     */
19    public int minCostConnectPoints(int[][] points) {
20        
21        int n = points.length;
22
23        Queue<int[]> priorityQueue = new PriorityQueue<>(
24            (int[] a, int[] b) -> {
25                return Integer.compare(a[2], b[2]);
26            }
27        );
28
29        boolean[] visited = new boolean[n];
30        visited[0] = true;
31        addAllNeigbours(priorityQueue, visited, 0, points);
32
33        int u = 0, v = 0, w = 0, cost = 0, edgeUsed = 0;
34
35        while(!priorityQueue.isEmpty()){
36            int[] edge = priorityQueue.poll();
37            u = edge[0]; u = edge[1]; w = edge[2];
38            if(visited[u] && visited[v]) continue;
39
40            cost += w;
41            if(!visited[u]){
42                visited[u] = true;
43                addAllNeigbours(priorityQueue, visited, u, points);
44            }
45            else{
46                visited[v] = true;
47                addAllNeigbours(priorityQueue, visited, v, points);
48            }
49            edgeUsed++;
50            if(edgeUsed == n-1) break;
51        }
52
53        return cost;
54    }
55}