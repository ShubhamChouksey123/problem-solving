1class Solution {
2    /**
3        Map containing email and its parent email 
4     */
5    Map<String, String> emailToParent;
6    /**
7        Map containing email and rank 
8     */
9    Map<String, Integer> emailToRank;
10
11    /**
12    map containing email and owner name
13     */
14    Map<String, String> emailToName;
15
16
17    private String find(String x){
18        if(! emailToParent.get(x).equals(x) ){
19            String root = find(emailToParent.get(x));
20            emailToParent.put(x, root);
21        }
22        return emailToParent.get(x);
23    }
24
25    private void union(String x, String y){
26        String rootX = find(x);
27        String rootY = find(y);
28
29        if( rootX.equals(rootY) )
30            return;
31        
32        if(emailToRank.get(rootX) > emailToRank.get(rootY)){
33            emailToParent.put(rootY, rootX);
34        }
35        else if(emailToRank.get(rootX) < emailToRank.get(rootY)){
36            emailToParent.put(rootX, rootY);
37        }
38        else{
39            emailToParent.put(rootY, rootX);
40            emailToRank.put(rootX, emailToRank.getOrDefault(rootX, 0) + 1);
41        }
42    }
43    
44    public List<List<String>> accountsMerge(List<List<String>> accounts) {
45
46        emailToParent = new HashMap<>();
47        emailToRank = new HashMap<>();
48        emailToName = new HashMap<>();
49
50        String name = null, rootEmail = null, email = null, parentEmail = null;
51        for(List<String> account : accounts){
52            name = account.get(0);
53            for(int i = 1 ; i < account.size() ; i++){
54                email = account.get(i);
55                emailToParent.put(email, email);
56                emailToRank.put(email, 1);
57                emailToName.put(email, name);
58            }
59        }
60
61        
62        for(List<String> account : accounts){
63            name = account.get(0);
64            rootEmail = account.get(1);
65            for(int i = 2 ; i < account.size() ; i++){
66                email = account.get(i);
67                union(rootEmail, email);   
68            }
69        }
70
71        List<List<String>> ans = new ArrayList<>();
72        /**
73            Map containing rootEmail and its associated emails
74         */
75        Map<String, List<String>> rootToEmails = new HashMap<>();
76
77        for(Map.Entry<String, String> entry : emailToParent.entrySet()){
78            email = entry.getKey();
79            rootEmail = find(email);
80            if(rootToEmails.containsKey(rootEmail)){
81                rootToEmails.get(rootEmail).add(email);
82                continue;
83            }
84            List<String> associatedEmails = new ArrayList<>();
85            associatedEmails.add(email);
86            rootToEmails.put(rootEmail, associatedEmails);
87        }
88
89        for(Map.Entry<String, List<String>> entry : rootToEmails.entrySet()){
90            Collections.sort(entry.getValue());
91            List<String> account = new ArrayList<>();
92            account.add(emailToName.get(entry.getKey()));
93            account.addAll(entry.getValue());
94            ans.add(account);
95        }
96        return ans;
97        
98    }
99}