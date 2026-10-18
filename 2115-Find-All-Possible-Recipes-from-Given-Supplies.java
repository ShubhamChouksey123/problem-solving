class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> inwardEdgeCount = new HashMap<>();

        for(int i = 0 ; i < recipes.length ; i++){
            String recipe = recipes[i];
            adj.putIfAbsent(recipe, new ArrayList<>());
            inwardEdgeCount.put(recipe, ingredients.get(i).size());

            for(String ingredient : ingredients.get(i)){
                adj.putIfAbsent(ingredient, new ArrayList<>());
                adj.get(ingredient).add(recipe);
                
            }
        }

        Deque<String> queue = new ArrayDeque<>();
        for(String supplie : supplies){
            queue.offerLast(supplie);
            inwardEdgeCount.put(supplie, 0);
        }
        
        List<String> canMake = new ArrayList<>();

        while(!queue.isEmpty()){
            String item = queue.pollFirst();

            if(!adj.containsKey(item)) continue;

            for(String neighbour : adj.get(item)){
                int currentEdge = inwardEdgeCount.getOrDefault(neighbour, 0);
                currentEdge--;
                inwardEdgeCount.put(neighbour, currentEdge);
                if(currentEdge == 0){
                    queue.offerLast(neighbour);
                    canMake.add(neighbour);
                }    
            }
        }
        return canMake;

    }
}