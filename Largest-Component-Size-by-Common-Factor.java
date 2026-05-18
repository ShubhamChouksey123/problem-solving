1class Solution {
2
3    private int[] rank;
4    private int[] parent;
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
17        if(rootX == rootY) return false;
18
19        if(rank[rootX] > rank[rootY]){
20            parent[rootY] = rootX;
21        }
22        else if(rank[rootX] < rank[rootY]){
23            parent[rootX] = rootY;
24        }
25        else{
26            parent[rootY] = rootX;
27            rank[rootX]++;
28        }
29        return true;
30    }
31
32    public int largestComponentSize(int[] nums) {
33
34        int n = nums.length;
35        int maxValue = 0;
36        for(int i = 0 ; i < n ; i++){
37            maxValue = Math.max(maxValue, nums[i]);
38        }
39
40        rank = new int[maxValue+1];
41        parent = new int[maxValue+1];
42        for(int i = 0 ; i <= maxValue ; i++){
43            parent[i] = i;
44            rank[i] = 1;
45        }
46
47        for(int i = 0 ; i < n ; i++){
48            int current = nums[i];
49            for(int factor = 2 ; factor * factor <= current ; factor++){
50                if(current % factor == 0){
51                    union(factor, nums[i]);
52                    while(current % factor == 0){
53                        current /= factor;
54                    }
55                }
56            }
57            if(current > 1){
58                union(current, nums[i]);
59            }
60        }
61
62
63        Map<Integer, Integer> count = new HashMap<>();
64        for(int i = 0 ; i < n ; i++){
65            int root = find(nums[i]);
66            count.put(root, count.getOrDefault(root, 0) + 1);
67        }
68
69        int maxConnectedComponent = 1;
70        for(int value : count.values()){
71            maxConnectedComponent = Math.max(maxConnectedComponent, value);
72        }
73        return maxConnectedComponent;
74    }
75}