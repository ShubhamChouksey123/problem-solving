1class Solution {
2
3    private double bfs(Map<String, List<Pair<String, Double>>> adj, String start, String end){
4
5        if(!adj.containsKey(start) || !adj.containsKey(end)) return -1.0;
6
7        if(start.equals(end)) return 1.0;
8        
9        String num = start;
10        double factor = 1.0;
11
12        Deque<Pair<String, Double>> queue = new ArrayDeque<>();
13        Set<String> visited = new HashSet<>();
14        
15        visited.add(start);
16        queue.offerLast(new Pair(start, factor));
17
18        while(!queue.isEmpty()){
19            Pair<String, Double> node = queue.pollFirst();
20            num = node.getKey();
21            factor = Double.valueOf(node.getValue());
22
23            if(num.equals(end)){
24                return factor;
25            }
26
27            for(Pair<String, Double> pair : adj.get(num)){
28                if(!visited.contains(pair.getKey())){
29                    visited.add(pair.getKey());
30                    queue.offerLast(new Pair(pair.getKey(), factor * pair.getValue()));
31                }
32
33            }
34        }
35
36        return -1.0;
37    }
38
39    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
40        int n = queries.size();
41        double[] result = new double[n];
42
43        Map<String, List<Pair<String, Double>>> adj = new HashMap<>();
44        
45        for(int i = 0 ; i < values.length ; i++){
46            List<String> equation = equations.get(i);
47            String u = equation.get(0);
48            String v = equation.get(1); 
49
50            if(adj.containsKey(u)){
51                adj.get(u).add(new Pair(v, values[i]));
52            }
53            else {
54                List<Pair<String, Double>> listU = new ArrayList<>();
55                listU.add(new Pair(v, values[i]));
56                adj.put(u, listU);
57            }
58            if(adj.containsKey(v)){
59                adj.get(v).add(new Pair(u, 1.0/values[i]));
60            }
61            else {
62                List<Pair<String, Double>> listV = new ArrayList<>();
63                listV.add(new Pair(u, 1.0/values[i]));
64                adj.put(v, listV);
65            }
66        }
67        
68        for(int i = 0 ; i < queries.size() ; i++){
69            List<String> query = queries.get(i);
70            result[i] = bfs(adj, query.get(0), query.get(1));
71        }
72        
73
74        return result;
75    }
76}