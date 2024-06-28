class Solution {
    

    private long calMaximumImportance(Map<Integer, Integer> vertexNumbers, int[][] roads) {

        long score = 0;
        int start = 0, end = 0;
        for(int[] road : roads){
            score = score + vertexNumbers.get(road[0]) + vertexNumbers.get(road[1]);
        }        
        return score;
    }

    private void createGraph(int n, int[][] roads, List<List<Integer>> graph, Map<Integer, Integer> vertexNumbers ) {

        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }

        int start = 0, end = 0;
        for(int[] road : roads){
            start = road[0]; end = road[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        Map<Integer, List<Integer>> counts = new TreeMap<>();

        for(int i = 0 ; i < n ; i++){
            int neighboursCount = graph.get(i).size();

            List<Integer> edges = counts.get(neighboursCount);
            if(edges == null){
                List<Integer> vertexes = new ArrayList<>();
                vertexes.add(i);
                counts.put(neighboursCount, vertexes);
            }else{
                edges.add(i);
                counts.put(neighboursCount, edges);
            } 
        }  

        
        start = 1;
        for(Map.Entry<Integer, List<Integer>> entry : counts.entrySet()){
            List<Integer> vertexes = entry.getValue();
            for(Integer vertex : vertexes){
                vertexNumbers.put(vertex, start);
                start++;
            }
        }  
        // System.out.println("vertexNumbers : " + vertexNumbers);

    }
    
    public long maximumImportance(int n, int[][] roads) {
        List<List<Integer>> graph = new ArrayList<>();
        Map<Integer, Integer> vertexNumbers = new HashMap<>();
        createGraph(n, roads, graph, vertexNumbers);
        return calMaximumImportance(vertexNumbers, roads);
    }
}