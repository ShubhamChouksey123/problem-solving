class Solution {

    private Map<String, Integer> stringToId;
    private int id;

    private double findSolution(List<Pair<Integer, Double>>[] adj, int n, int source, int destination){
        
        if(source == -1 || destination == -1) return -1d;
        if(source == destination) return 1d;
        
        
        boolean[] visited = new boolean[n]; 
        Deque<double[]> queue = new ArrayDeque<>();
        queue.offerLast(new double[]{source, 1d});
        visited[source] = true;

        while(!queue.isEmpty()){
            double[] top = queue.pollFirst();

            int node = (int)top[0];
            double factor = top[1];

            if(node == destination) return factor;

            for(Pair<Integer, Double> pair : adj[node]){
                int neighbour = pair.getKey();
                
                if(visited[neighbour]) continue;

                visited[neighbour] = true;
                queue.offerLast(new double[]{neighbour, factor * pair.getValue()});

            }
        }
        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        int length = equations.size();
        id = 0;
        stringToId = new HashMap<>();
        

        for(int i = 0 ; i < equations.size() ; i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            stringToId.putIfAbsent(u, id++);
            stringToId.putIfAbsent(v, id++);
        }

        int n = id;
        List<Pair<Integer, Double>>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < equations.size() ; i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            int uId = stringToId.get(u);
            int vId = stringToId.get(v);
            adj[uId].add(new Pair<>(vId, values[i]));
            adj[vId].add(new Pair<>(uId, 1/values[i]));
        }

        int queriesLength = queries.size();
        double[] result = new double[queriesLength];
        for(int i = 0 ; i < queriesLength ; i++){
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);   
            int uId = stringToId.getOrDefault(u, -1);
            int vId = stringToId.getOrDefault(v, -1);


            result[i] = findSolution(adj, n, uId, vId);
        }
        return result;
    }
}