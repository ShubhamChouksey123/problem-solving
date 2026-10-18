class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();
        boolean[] visited = new boolean[n];
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(0);
        visited[0] = true;

        while(!queue.isEmpty()){

            Integer node = queue.pollFirst();

            for(Integer neighbour : rooms.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offerLast(neighbour);
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}