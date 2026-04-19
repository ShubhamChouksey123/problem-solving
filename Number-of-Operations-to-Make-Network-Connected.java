1class Solution {
2    
3    private int[] parent;
4    private int[] rank;
5
6    private int find(int x){
7        if(parent[x] != x){
8            parent[x] = find(parent[x]);
9        }
10        return parent[x];
11    }
12
13    private void union(int x, int y){
14        int rootX = find(x);
15        int rootY = find(y);
16
17        if(rootX == rootY)  
18            return;
19
20        if(rank[rootX] > rank[rootY]){
21            parent[rootY] = rootX;
22        }
23        else if(rank[rootX] < rank[rootY]){
24            parent[rootX] = rootY;
25        }
26        else{
27            parent[rootY] = rootX;
28            rank[rootX]++;
29        }
30    }
31
32    public int makeConnected(int n, int[][] connections) {
33        
34        parent = new int[n];
35        rank = new int[n];
36
37        for(int i = 0 ; i < n ; i++){
38            parent[i] = i;
39            rank[i] = 1;
40        }
41
42        int edgesNotNeeded = 0;
43        for(int[] connection : connections){
44            int x = connection[0], y = connection[1];
45            int rootX = find(x);
46            int rootY = find(y); 
47            if(rootX == rootY){
48                edgesNotNeeded++;
49            }else{
50                union(connection[0], connection[1]);
51            }
52        }
53        
54
55        Set<Integer> roots = new HashSet<>();
56        for(int i = 0 ; i < n ; i++){
57            int root = find(i);
58            roots.add(root);
59        }
60        int edgesNeeded = roots.size() - 1;
61
62        if(edgesNeeded > edgesNotNeeded){
63            return -1;
64        }
65        return edgesNeeded;
66    }
67}