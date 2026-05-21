1class Solution {
2
3    private List<String> ans;
4    private int n;
5
6    private void dfs(Map<String, PriorityQueue<String>> adj, String start, LinkedList<String> iternary){
7        PriorityQueue<String> destinations = adj.get(start);
8
9        while(!destinations.isEmpty()){
10            
11            String airport = destinations.poll();
12            dfs(adj, airport, iternary);
13        }
14
15        iternary.addFirst(start);
16    }
17
18    public List<String> findItinerary(List<List<String>> tickets) {
19
20        Map<String, PriorityQueue<String>> adj = new HashMap<>();
21
22        for(List<String> ticket : tickets){
23            String from = ticket.get(0), to = ticket.get(1); 
24            adj.putIfAbsent(from, new PriorityQueue<>());
25            adj.putIfAbsent(to, new PriorityQueue<>());
26            adj.get(from).add(to);
27        }
28
29        LinkedList<String> iternary = new LinkedList<>();
30        dfs(adj, "JFK", iternary);
31        return iternary;
32    }
33}