1class Solution {
2
3    private Map<String, Integer> emailToAccountId;
4    private Map<String, String> emailToName;
5
6
7    private int[] parent;
8    private int[] rank;
9
10    private int find(int x){
11        if(parent[x] != x){
12            parent[x] = find(parent[x]);
13        }
14        return parent[x];
15    }
16
17    private boolean union(int x, int y){
18        int rootX = find(x);
19        int rootY = find(y);
20
21        if(rootX == rootY) return false;
22
23        if(rank[rootX] > rank[rootY]){
24            parent[rootY] = rootX;
25        }
26        if(rank[rootX] < rank[rootY]){
27            parent[rootX] = rootY;
28        }
29        else{
30            parent[rootY] = rootX;
31            rank[rootX]++;
32        }
33        return true;
34    }
35
36    public List<List<String>> accountsMerge(List<List<String>> accounts) {
37
38        int n = accounts.size();
39        parent = new int[n];
40        rank = new int[n];
41        emailToAccountId = new HashMap<>();
42        emailToName = new HashMap<>();
43
44        for(int i = 0 ; i < accounts.size() ; i++){
45            parent[i] = i;
46            rank[i] = 1;
47        }
48
49        for(int i = 0 ; i < accounts.size(); i++){
50            String name = accounts.get(i).get(0);
51            
52            for(int j = 1 ; j < accounts.get(i).size() ; j++){
53                String email =  accounts.get(i).get(j);
54                emailToName.put(email, name);
55
56                if(emailToAccountId.containsKey(email)){
57                    int accountId = emailToAccountId.get(email);
58                    union(accountId, i);
59                }
60                else{
61                    emailToAccountId.put(email, i);
62                }
63            }
64        }
65
66        Map<Integer, List<String>> accountsIdEmailMap = new HashMap<>();
67
68        for(Map.Entry<String, Integer> entry : emailToAccountId.entrySet()){
69            String email = entry.getKey();
70            int rootAccountId = find(entry.getValue());
71
72            accountsIdEmailMap.putIfAbsent(rootAccountId, new ArrayList<>());
73            accountsIdEmailMap.get(rootAccountId).add(email);
74        }
75         
76
77        List<List<String>> ans = new ArrayList<>();
78
79        for(Map.Entry<Integer, List<String>> entry : accountsIdEmailMap.entrySet()){
80            Collections.sort(entry.getValue());
81
82            String name = emailToName.get(entry.getValue().get(0));
83            List<String> eachRow = new ArrayList<>();
84            eachRow.add(name);
85            eachRow.addAll(entry.getValue());
86            ans.add(eachRow);
87        }
88
89        return ans;
90        
91        
92    }
93}