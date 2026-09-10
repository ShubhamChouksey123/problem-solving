class Solution {

    private boolean dfs(List<Integer>[] adj, Deque<Integer> stack, List<Integer> reverseAns, boolean[] addedInResult, boolean[] addedInStack,  int node){

        stack.offerLast(node);
        addedInStack[node] = true;

        for(int neighbour : adj[node]){
            if(addedInResult[neighbour]) continue;
            if(addedInStack[neighbour]) return false;

            if(!dfs(adj, stack, reverseAns, addedInResult, addedInStack,  neighbour)){
                return false;
            }
        }

        stack.pollLast();
        reverseAns.add(node);
        addedInStack[node] = false;
        addedInResult[node] = true;
        return true;
    } 

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
        List<Integer> reverseAns = new ArrayList<>();
        boolean[] addedInResult = new boolean[numCourses];
        boolean[] addedInStack = new boolean[numCourses];


        for(int i = 0 ; i < numCourses ; i++){
            if(!addedInResult[i]){
                if(!dfs(adj, stack, reverseAns, addedInResult, addedInStack, i)){
                    return new int[0];
                }
            }
        }

        int[] ans = new int[numCourses];
        for(int i = 0 ; i <  numCourses ; i++){
            ans[i] = reverseAns.get(numCourses - i - 1);
        }
        return ans;
    }
}