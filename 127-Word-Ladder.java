class Solution {

    private boolean areNeighbour(String p, String q){

        if(p.length() != q.length()) return false;

        int diff = 0;
        for(int i = 0 ; i < p.length() ; i++){
            if(p.charAt(i) != q.charAt(i)) diff++;

            if(diff > 1) return false;
        }

        return diff == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        
        int n = wordList.size();
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }

        int endIndex = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j) continue;
                if(areNeighbour(wordList.get(i), wordList.get(j))){
                    adj[i].add(j); 
                }
            }
            if(Objects.equals(wordList.get(i), endWord)){
                endIndex = i;
            }
        }

        if(endIndex == Integer.MAX_VALUE) return 0;
        

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0 ; i < n ; i++){
            if(areNeighbour(wordList.get(i), beginWord)){
                queue.offerLast(new int[]{i, 2});
                visited[i] = true; 
            }
        }


        int node = 0, length = 0;
        int ans = 0;
        while(!queue.isEmpty()){
            int[] top = queue.pollFirst();
            node = top[0]; length = top[1];

            if(node == endIndex) return length;

            for(int neighbour : adj[node]){

                if(visited[neighbour]) continue;

                visited[neighbour] = true;
                queue.offerLast(new int[]{neighbour, length + 1});
            }
        }

        return ans;
    }
}