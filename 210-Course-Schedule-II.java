class Solution {


    private boolean dfs(List<Integer>[] adj, Deque<Integer> stack, boolean[] visited, boolean[] inStack, List<Integer> reverseOrderList, int node){

        if(visited[node]) return true;
        if(inStack[node]) return false;

        inStack[node] = true;

        for(int neighbour : adj[node]){
            if(visited[neighbour]) continue;
            if(!dfs(adj, stack, visited, inStack, reverseOrderList, neighbour)){
                return false;
            }
        }

        inStack[node] = false;
        visited[node] = true;
        reverseOrderList.add(node);
        return true;
    }
    /**
        DFS based topological sorting
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            adj[i] = new ArrayList<>();
        }
        

        for(int[] prerequisite : prerequisites){
            int u = prerequisite[1];
            int v = prerequisite[0];
            adj[u].add(v);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        List<Integer> reverseOrderList = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
           if(!visited[i]){
                if(!dfs(adj, stack, visited, inStack, reverseOrderList, i)){
                    return new int[0];
                }
           }
        }
        int[] ans = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            ans[i] = reverseOrderList.get(numCourses - i - 1);
        } 
        return ans;      
    }
}