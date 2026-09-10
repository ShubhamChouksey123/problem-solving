class Solution {
    // Kahn's Algorithm 
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] adj = new ArrayList[numCourses];
        int[] inwardEdgeCount = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] prerequisite: prerequisites){
            int u = prerequisite[1];
            int v = prerequisite[0];
            adj[u].add(v); 
            inwardEdgeCount[v]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(inwardEdgeCount[i] == 0) queue.offerLast(i);
        }

        List<Integer> topologicalOrder = new ArrayList<>(); 
        while(!queue.isEmpty()){
            int node = queue.pollFirst();
            topologicalOrder.add(node);

            for(int neighbour : adj[node]){
                if(--inwardEdgeCount[neighbour] == 0) queue.offerLast(neighbour);
            }
        }

        return topologicalOrder.size() == numCourses; 
    }
}