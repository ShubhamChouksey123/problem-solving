1class Solution {
2
3    private boolean isCyclicutil(Map<Integer, Set<Integer>> adj, boolean[] visited, boolean[] inStack, Deque<Integer> deque, int node){
4        inStack[node] = true;
5        visited[node] = true;
6
7        Set<Integer> neighbours = adj.get(node);
8        if(neighbours != null && !neighbours.isEmpty()) {
9
10            for(Integer neighbour : neighbours){
11                if(inStack[neighbour]) return true;
12                if(!visited[neighbour] && isCyclicutil(adj, visited, inStack, deque, neighbour)){
13                    return true;
14                }
15            }    
16        }
17  
18
19        inStack[node] = false;
20        deque.offerFirst(node);
21        return false;
22    }
23
24    private boolean isCyclic(Map<Integer, Set<Integer>> adj){
25        boolean[] visited = new boolean[61];
26        boolean[] inStack = new boolean[61];
27
28        Deque<Integer> deque = new ArrayDeque<>();
29
30        for(int color = 1 ; color <= 60 ; color++){
31            if(!visited[color] && adj.containsKey(color)){
32                if(isCyclicutil(adj, visited, inStack, deque, color))
33                    return true;
34            }
35        }
36        return false;
37    }
38    
39    
40    public boolean isPrintable(int[][] targetGrid) {
41        
42        int n = targetGrid.length, m = targetGrid[0].length;
43        // minR, maxR, minC, maxC 
44        int[][] minMax = new int[61][4]; 
45
46        for(int color = 1 ; color <= 60 ; color++){
47            minMax[color][0] = Integer.MAX_VALUE;  minMax[color][2] = Integer.MAX_VALUE;
48            minMax[color][1] = Integer.MIN_VALUE;  minMax[color][3] = Integer.MIN_VALUE;
49            
50        }
51
52        for(int i = 0 ; i < n ; i++){
53            for(int j = 0 ; j < m ; j++){
54                int color = targetGrid[i][j];
55
56                minMax[color][0] = Math.min(minMax[color][0], i);
57                minMax[color][1] = Math.max(minMax[color][1], i);
58
59                minMax[color][2] = Math.min(minMax[color][2], j);
60                minMax[color][3] = Math.max(minMax[color][3], j);
61            }
62        }
63
64        Map<Integer, Set<Integer>> adj = new HashMap<>();
65
66
67        for(int color = 1 ; color <= 60 ; color++){
68            int minR = minMax[color][0], maxR = minMax[color][1];
69            int minC = minMax[color][2], maxC = minMax[color][3];
70
71            if(minR == Integer.MAX_VALUE) continue;
72
73            for(int i = minR ; i <= maxR ; i++){
74                for(int j = minC ; j <= maxC ; j++){
75                    int otherColor = targetGrid[i][j];
76
77                    if(color == otherColor) continue;
78                    adj.putIfAbsent(color, new HashSet<>());
79                    adj.get(color).add(otherColor);
80                }
81            }
82        }
83
84        return !isCyclic(adj);
85    }
86}