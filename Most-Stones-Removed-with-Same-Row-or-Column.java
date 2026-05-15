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
13    private boolean union(int x, int y){
14        int rootX = find(x);
15        int rootY = find(y);
16
17        if(rootX == rootY){
18            return false;
19        }
20
21        if(rank[rootX] > rank[rootY]){
22            parent[rootY] = parent[rootX];
23        }
24        if(rank[rootX] < rank[rootY]){
25            parent[rootX] = parent[rootY];
26        }
27        else{
28            parent[rootY] = parent[rootX];
29            rank[rootX]++;
30        }
31        return true;
32    }
33
34    public int removeStones(int[][] stones) {
35        int n = stones.length; 
36
37        int maxValue = 0;
38        for(int i = 0 ; i < n ; i++){
39            maxValue = Math.max( Math.max(stones[i][0], stones[i][1]), maxValue);
40        }    
41
42        int size = maxValue;
43        parent = new int[n];
44        rank = new int[n];
45
46        for(int i = 0; i < n ; i++){
47            parent[i] = i;
48            rank[i] = 1;
49        }
50
51        
52        for(int i = 0 ; i < n ; i++){
53            int row = stones[i][0], col = stones[i][1];
54            for(int j = 0 ; j < n ; j++){
55                if(stones[j][0] == row || stones[j][1] == col){
56                    union(i, j);   
57                }
58            }
59        }    
60
61        Set<Integer> set = new HashSet<>();
62        for(int i = 0 ; i < n ; i++){
63            set.add(find(i));
64        }
65
66        return n - set.size();
67
68
69
70
71
72    }
73}