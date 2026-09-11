class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        double[] maxProbality = new double[n];
        Arrays.fill(maxProbality, 0);

        List<double[]>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }
        int index = 0;
        for(int[] edge : edges){
            double u = edge[0], v = edge[1], w = succProb[index++];
            adj[(int)u].add(new double[]{v, w});
            adj[(int)v].add(new double[]{u, w});
        }


        // each element as {node, distance}
        Queue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[1], a[1])
        );
        pq.add(new double[]{start_node, 1});  

        while(!pq.isEmpty()){

            double[] topElement = pq.poll();
            double node = topElement[0]; double dist = topElement[1];

            
            if(maxProbality[(int)node] > dist) continue;
            maxProbality[(int)node] = dist;

            if(node == end_node) break;


            for(double[] neighboutInfo : adj[(int)node]){
                double neighbourNode = neighboutInfo[0];
                double edgeWeight = neighboutInfo[1];
                if(maxProbality[(int)node] * edgeWeight > maxProbality[(int)neighbourNode]){
                    maxProbality[(int)neighbourNode] = maxProbality[(int)node] * edgeWeight;
                    pq.add(new double[]{neighbourNode, maxProbality[(int)node] * edgeWeight});  
                }
            }
        }      
        
        return maxProbality[end_node];

    }
}