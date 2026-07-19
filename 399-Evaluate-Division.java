class Solution {

    private Double id; 

    private double bfs(List<double[]>[] adj, Map<String, Double> stringToId, List<String> query){

        double start = stringToId.getOrDefault(query.get(0), -1d);
        double end = stringToId.getOrDefault(query.get(1), -1d);

        if(start == -1d || end == -1d) return -1d;

        if(start == end) return 1d;


        boolean[] visited = new boolean[adj.length];

        Deque<double[]> queue = new ArrayDeque<>();
        queue.offerLast(new double[]{start, 1d});
        visited[(int)start] = true;

        double node = -1d, factor = 1;

        while(!queue.isEmpty()){
            double[] element = queue.pollFirst();
            node = element[0];
            factor = element[1];

            if(node == end) return factor;

            for(double[] neighbourInfo : adj[(int)node]){
                double neighbourNode = neighbourInfo[0];
                double multiplier = neighbourInfo[1];

                if(!visited[(int)neighbourNode]){
                    visited[(int)neighbourNode] = true;
                    queue.offerLast(new double[]{neighbourNode, factor * multiplier});
                }
            }   
        }
        return -1d;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        id = 0d;
        Map<String, Double> stringToId = new HashMap<>();
        for(int i = 0 ; i < equations.size() ; i++){
            if(!stringToId.containsKey(equations.get(i).get(0))){
                stringToId.put(equations.get(i).get(0), id++);
            }
            if(!stringToId.containsKey(equations.get(i).get(1))){
                stringToId.put(equations.get(i).get(1), id++);
            }
        } 

        int n = stringToId.size();
        List<double[]>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        } 

        for(int i = 0 ; i < equations.size() ; i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            double aId = stringToId.get(a);
            double bId = stringToId.get(b);

            adj[(int)aId].add(new double[]{bId, value});
            adj[(int)bId].add(new double[]{aId, 1.0/value});
        } 

        int queriesLength = queries.size();
        double[] ans = new double[queriesLength];

        for(int i = 0 ; i < queriesLength ; i++){
            ans[i] = bfs(adj, stringToId, queries.get(i));
        }

        return ans;
    }
}