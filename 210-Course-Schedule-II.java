class Solution {

    /**
        Kahn's Algorithm
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            adj[i] = new ArrayList<>();
        }

        int[] inwardEdges = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            int u = prerequisite[1];
            int v = prerequisite[0];
            inwardEdges[v]++;
            adj[u].add(v);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(inwardEdges[i] == 0) queue.offerLast(i);
        }

        int[] ans = new int[numCourses];
        int indexAt = 0;
        while(!queue.isEmpty()){

            int node = queue.pollFirst();
            ans[indexAt++] = node;

            for(int neighbour : adj[node]){
                inwardEdges[neighbour]--;
                if(inwardEdges[neighbour] == 0){
                    queue.offerLast(neighbour);
                }
            }
        }

        if(indexAt != numCourses) return new int[0];
        return ans;
    }
}