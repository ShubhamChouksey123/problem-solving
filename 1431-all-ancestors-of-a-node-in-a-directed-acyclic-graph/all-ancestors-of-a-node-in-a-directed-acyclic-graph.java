class Solution {
    
    private void getAncestors(int n, Map<Integer, Set<Integer>> parents, List<List<Integer>> ans, int vertex){
        boolean[] visited = new boolean[n];

        List<Integer> ancestors = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> st = parents.get(vertex);
        if(st != null && !st.isEmpty()){
            st.forEach(
                (parent) -> {
                    visited[parent] = true;
                    queue.add(parent);
                } 
            );
        }

        while(!queue.isEmpty()){
            Integer parent = queue.poll();
            ancestors.add(parent);

            st = parents.get(parent);
            if(st != null && !st.isEmpty()){
                Iterator<Integer> it = st.iterator();
                while(it != null && it.hasNext()){
                    int newParent = it.next();
                    if(!visited[newParent]){
                        visited[newParent] = true;
                        queue.add(newParent);
                    }
                }
            }
            
        }
        Collections.sort(ancestors);
        ans.add(ancestors);
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        Map<Integer, Set<Integer>> parents = new TreeMap<>();

        for(int[] edge : edges){
            int start = edge[0];
            int end   = edge[1];

            Set<Integer> st = parents.get(end);
            if(st == null){
                st = new TreeSet<>();
                st.add(start);
                parents.put(end, st);
            }else{
                st.add(start);
                parents.put(end, st);
            }
        }  

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            getAncestors(n, parents, ans, i);
        }
        return ans;
        
    }
}