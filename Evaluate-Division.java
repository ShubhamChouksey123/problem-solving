1class Solution {
2
3    private double bfs(List<List<String>> equations, double[] values, String start, String end){
4
5        
6        Set<String> visited = new HashSet<>();
7        visited.add(start);
8
9        Deque<String[]> queue = new ArrayDeque<>();
10
11        for(int i = 0 ; i < values.length ; i++){
12            List<String> equation = equations.get(i);
13            if(equation.get(0).equals(start) && !visited.contains(equation.get(1))){
14                if(start.equals(end)){
15                    return 1.0;
16                }
17                visited.add(equation.get(1));
18                queue.offerLast(new String[]{equation.get(1), String.valueOf(values[i])});
19            }
20        }
21        for(int i = 0 ; i < values.length ; i++){
22            List<String> equation = equations.get(i);
23            if(equation.get(1).equals(start) && !visited.contains(equation.get(0))){
24                if(start.equals(end)){
25                    return 1.0;
26                }
27                visited.add(equation.get(0));
28                queue.offerLast(new String[]{equation.get(0), String.valueOf(1/ values[i])});
29             
30            }
31        }
32        
33        String num = start;
34        String den ;
35        double factor = 1;
36
37
38
39        while(!queue.isEmpty()){
40            String[] node = queue.pollFirst();
41            den = node[0];
42            factor = Double.valueOf(node[1]);
43
44            if(den.equals(end)){
45                return factor;
46            }
47
48            for(int i = 0 ; i < values.length ; i++){
49                List<String> equation = equations.get(i);
50                if(equation.get(0).equals(den) && !visited.contains(equation.get(1))  ){
51                    visited.add(equation.get(1));
52                    queue.offerLast(new String[]{equation.get(1), String.valueOf(factor * values[i])});
53                }
54            }
55            for(int i = 0 ; i < values.length ; i++){
56                List<String> equation = equations.get(i);
57                if(equation.get(1).equals(den) && !visited.contains(equation.get(0))   ){
58                    visited.add(equation.get(0));
59                    queue.offerLast(new String[]{equation.get(0), String.valueOf(factor * 1/values[i])});
60                }
61            }
62        }
63
64        return -1.0;
65    }
66
67    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
68        int n = queries.size();
69        double[] result = new double[n];
70        
71        for(int i = 0 ; i < queries.size() ; i++){
72            List<String> query = queries.get(i);
73            result[i] = bfs(equations, values, query.get(0), query.get(1));
74
75            // if(result[i] == -1.00){
76            //     result[i] = bfs(equations, values, query.get(1), query.get(0), true);
77            // }
78        }
79        
80
81        return result;
82    }
83}