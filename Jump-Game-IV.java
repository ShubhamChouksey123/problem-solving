1class Solution {
2    public int minJumps(int[] arr) {
3        
4        int n = arr.length;
5        Map<Integer, List<Integer>> adj = new HashMap<>();
6        
7        for(int i = 0 ; i < n ; i++){
8            if(!adj.containsKey(arr[i])){
9                adj.put(arr[i], new ArrayList<>());
10            }
11            adj.get(arr[i]).add(i);
12        }
13        
14        boolean[] visited = new boolean[n]; 
15
16        Deque<Integer> queue = new ArrayDeque<>();
17        queue.offerLast(0);
18        visited[0] = true;
19        int jump = 0;
20
21        while(!queue.isEmpty()){
22
23            int size = queue.size();
24            for(int i = 0 ; i < size ; i++){
25
26                int node = queue.pollFirst();
27                if(node == n - 1) return jump;
28
29                if(node + 1 < n && !visited[node + 1]) {
30                    queue.offerLast(node + 1);
31                    visited[node + 1] = true;
32                }
33                if(node - 1 >= 0 && !visited[node - 1]) {
34                    queue.offerLast(node - 1);
35                    visited[node - 1] = true;
36                }
37                if(adj.containsKey(arr[node])){
38                    for(int neighbour : adj.get(arr[node])){
39                        if(!visited[neighbour]){
40                            queue.offerLast(neighbour);
41                            visited[neighbour] = true;
42                        }
43                    }
44                    adj.remove(arr[node]);
45                }
46                
47            }
48            jump++;
49        }
50        return jump;
51    }
52}