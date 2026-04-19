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
32
33    public boolean equationsPossible(String[] equations) {
34
35        parent = new int[26];
36        rank = new int[26];
37
38        for(int i = 0 ; i < 26 ; i++){
39            parent[i] = i;
40            rank[i] = 1;
41        }
42
43        for(String equation : equations){
44            int x = equation.charAt(0) - 'a';
45            int y = equation.charAt(3) - 'a';
46            if(equation.charAt(1) == '='){
47                union(x, y);
48            }
49        }
50
51        for(String equation : equations){
52            int x = equation.charAt(0) - 'a';
53            int y = equation.charAt(3) - 'a';
54            if(equation.charAt(1) == '!'){
55                int rootX = find(x);
56                int rootY = find(y);
57                if(rootX == rootY)
58                    return false;
59            }
60        }
61
62        return true;
63    }
64}