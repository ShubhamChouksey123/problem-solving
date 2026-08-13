class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            adj[i] = new ArrayList<>();
        }

        int[] inwardEdgesCount = new int[numCourses]; 
        for(int[] prerequisite : prerequisites){
            inwardEdgesCount[prerequisite[0]]++;
            adj[prerequisite[1]].add(prerequisite[0]);
        }


        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(inwardEdgesCount[i] == 0)
                queue.offerLast(i);
        }

        int indexAt = 0;
        int[] ans = new int[numCourses];
        
        while(!queue.isEmpty()){
            int node = queue.pollFirst();
            ans[indexAt++] = node;

            for(int neighbour : adj[node]){
                if(--inwardEdgesCount[neighbour] == 0) queue.offerLast(neighbour);
            }
        }

        if(indexAt != numCourses) return new int[0];

        return ans;
    }
}