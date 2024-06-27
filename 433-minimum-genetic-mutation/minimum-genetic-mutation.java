class Solution {

    private static final int GENE_LENGTH = 8;

    private int getIndex(List<String> genes,int n, String searchingGene){
        for(int i = 0 ; i < n ; i++){
            String gene = genes.get(i);
            if(Objects.equals(gene, searchingGene)){
                return i;
            }
        }
        return -1;
    }

    private boolean isMutation(String gene1, String gene2) {
        int count = 0;
        for(int i = 0 ; i < GENE_LENGTH ; i++){
            if(gene1.charAt(i) != gene2.charAt(i)){
                count++;
            }
        }
        if(count == 1){
            return true;
        }
        return false;
    }

    private void createGraph(List<List<Integer>> graph, List<String> genes, int n) {

        for(int i = 0 ; i < n ; i++){
            String gene = genes.get(i);
            List<Integer> neighbours = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                if( i == j ){
                    continue;
                }
                if(isMutation(gene, genes.get(j))){
                   neighbours.add(j);
                }
            }
            graph.add(neighbours);
        }

        for(int i = 0 ; i < n ; i++){
            List<Integer> neighboures = graph.get(i);
            System.out.println("Gene : " + genes.get(i) + " for i " + i + " has neighbours : " + neighboures);
        }
        
    }

    private int minDistance(List<List<Integer>> graph, int startIndex, int endIndex, int n) {

        System.out.println("startIndex : " + startIndex + " and endIndex " + endIndex );
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex);
        queue.add(null);
        visited[startIndex] = true;
        int level = 0; boolean found = false;

        while(!queue.isEmpty()){
            Integer top = queue.poll();


            if(top == null){
                if(!queue.isEmpty()){
                    queue.add(null);
                    level++;
                    continue;
                }else{
                    // TODO:
                    break; 
                }
            }

            if(top == endIndex){
                found = true;
                break;
            }

            for(Integer neighbour : graph.get(top)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        if(found){
            return level;
        }
        return -1;
    }

    
    
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        List<String> genes = new ArrayList<>(10);
        for(String gene: bank){
            genes.add(gene);
        }

        if(!genes.contains(startGene)){
            genes.add(0, startGene);
        }
        if(!genes.contains(endGene)){
            return -1;
        }

        System.out.println("genes : " + genes);

        int n = genes.size();

        int startIndex = getIndex(genes, n, startGene);
        int endIndex   = getIndex(genes, n, endGene);
        List<List<Integer>> graph = new ArrayList<>();
        createGraph(graph, genes, n);

        int minDistance = minDistance(graph, startIndex, endIndex, n);
        return minDistance; 
    }
}


/**
"AACCGGTT"
"AACCGGTA"
["AACCGGTA"]
"AACCGGTT"
"AAACGGTA"
["AACCGGTA","AACCGCTA","AAACGGTA"]
 */