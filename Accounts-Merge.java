1class Solution {
2    /**
3        Map containing email and its parent email 
4     */
5    Map<String, String> parent;
6    /**
7        Map containing email and rank 
8     */
9    Map<String, Integer> rank;
10
11    /**
12    map containing email and owner name
13     */
14    Map<String, String> emailToName;
15
16
17    private String find(String x){
18        if(!Objects.equals(parent.get(x), x)){
19            String root = find(parent.get(x));
20            parent.put(x, root);
21        }
22        return parent.get(x);
23    }
24
25    private boolean union(String x, String y){
26        String rootX = find(x);
27        String rootY = find(y);
28
29        if( rootX.equals(rootY) )
30            return false;
31        
32        if(rank.get(rootX) > rank.get(rootY)){
33            parent.put(rootY, rootX);
34        }
35        else if(rank.get(rootX) < rank.get(rootY)){
36            parent.put(rootX, rootY);
37        }
38        else{
39            parent.put(rootY, rootX);
40            rank.put(rootX, rank.getOrDefault(rootX, 0) + 1);
41        }
42        return true;
43    }
44    
45    public List<List<String>> accountsMerge(List<List<String>> accounts) {
46
47        parent = new HashMap<>();
48        rank = new HashMap<>();
49        emailToName = new HashMap<>();
50
51        String name = null, rootEmail = null, email = null, parentEmail = null;
52        for(List<String> account : accounts){
53            name = account.get(0);
54            for(int i = 1 ; i < account.size() ; i++){
55                email = account.get(i);
56                parent.put(email, email);
57                rank.put(email, 1);
58                emailToName.put(email, name);
59            }
60        }
61
62        
63        for(List<String> account : accounts){
64            name = account.get(0);
65            rootEmail = account.get(1);
66            for(int i = 2 ; i < account.size() ; i++){
67                email = account.get(i);
68                union(rootEmail, email);   
69            }
70        }
71
72        List<List<String>> ans = new ArrayList<>();
73        /**
74            Map containing rootEmail and its associated emails
75         */
76        Map<String, List<String>> rootToEmails = new HashMap<>();
77
78        for(Map.Entry<String, String> entry : parent.entrySet()){
79            email = entry.getKey();
80            rootEmail = find(email);
81            if(rootToEmails.containsKey(rootEmail)){
82                rootToEmails.get(rootEmail).add(email);
83                continue;
84            }
85            List<String> associatedEmails = new ArrayList<>();
86            associatedEmails.add(email);
87            rootToEmails.put(rootEmail, associatedEmails);
88        }
89
90        for(Map.Entry<String, List<String>> entry : rootToEmails.entrySet()){
91            Collections.sort(entry.getValue());
92            List<String> account = new ArrayList<>();
93            account.add(emailToName.get(entry.getKey()));
94            account.addAll(entry.getValue());
95            ans.add(account);
96        }
97        return ans;
98        
99    }
100}