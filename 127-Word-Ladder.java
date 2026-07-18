class Solution {

    private boolean isNeighbour(String a, String b){
        if(a.length() != b.length()) return false;

        int diff = 0;
        for(int i = 0 ; i < a.length() ; i++){
            if(a.charAt(i) != b.charAt(i)) diff++;

            if(diff > 1) return false;
        }

        return diff == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int n = wordList.size();
        boolean[] visited = new boolean[n];

        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j) continue;
                if(isNeighbour(wordList.get(i), wordList.get(j) ) ){
                    adj[i].add(j);
                }
            }
        }

        Deque<int[]> queue = new ArrayDeque<>();
        
        for(int i = 0 ; i < n ; i++){
            if(isNeighbour(beginWord, wordList.get(i)) ){
                visited[i] = true;
                queue.offerLast(new int[]{i, 2});
            }
        }   


        while(!queue.isEmpty()){

            int[] element = queue.pollFirst();
            int node = element[0], numberofWords = element[1];
            if(Objects.equals(wordList.get(node), endWord)){
                return numberofWords;
            }

            for(int neighbour : adj[node]){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offerLast(new int[]{neighbour, numberofWords + 1});
                }
            }
        }

        return 0;
    }
}