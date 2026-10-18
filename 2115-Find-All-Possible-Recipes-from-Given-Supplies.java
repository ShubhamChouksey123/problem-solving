class Solution {

    private boolean isAllAvailable(List<String> ingredientsForRecipe, Set<String> available){
        for(String ingredient : ingredientsForRecipe){
            if(!available.contains(ingredient)) return false;
        }
        return true;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> available = new HashSet<>();
        List<String> canCreate = new ArrayList<>();
        for(String supplie : supplies){
            available.add(supplie);
        }

        boolean added = true;
        int n = recipes.length;

        boolean[] visited = new boolean[n];

        while(added){
            added = false;
            for(int i = 0 ; i < n ; i++){
                if(visited[i]) continue;

                if(isAllAvailable(ingredients.get(i), available)){
                    added = true;
                    visited[i] = true;
                    available.add(recipes[i]);
                    canCreate.add(recipes[i]);
                }
            }
        }
        return canCreate;
        
    }
}