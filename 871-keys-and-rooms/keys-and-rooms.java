class Solution {
    
    private void canVisitAllRoomsUtil(List<List<Integer>> rooms, boolean[] visited, int room) {
       
        visited[room] = true;

        for(int key: rooms.get(room)){
            if(!visited[key]){
                canVisitAllRoomsUtil(rooms, visited, key);
            }
        }
    }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int totalRooms = rooms.size();
        boolean[] visited = new boolean[totalRooms];

        canVisitAllRoomsUtil(rooms, visited, 0);

        for(boolean room: visited){
            if(room == false){
                return false;
            }
        }
        return true;



    }
}