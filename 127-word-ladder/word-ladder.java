class Solution {

    private void createGraph(Map<String, Set<String>> map, int m, Map<String, Integer> wordIndex, List<List<Integer>> graph, List<String> wordList) {

        

        for(int i = 0 ; i < wordList.size() ; i++){
            String word = wordList.get(i);
            System.out.println("all patterns for word : " + word);
            List<Integer> neighbours = new ArrayList<>();
            for(int j = 0 ; j < m ; j++){
                String pattern = word.substring(0, j) + "*" + word.substring(j+1, m);
                Set<String> matchedWords = map.get(pattern);
                for(String matchedWord : matchedWords){
                    if(matchedWord == word){
                        continue;
                    }
                    if(!neighbours.contains(matchedWord)){
                        neighbours.add(wordIndex.get(matchedWord));
                    }
                }
            }
            graph.add(i, neighbours);
        }
        

        for(int i = 0 ; i < wordList.size() ; i++){
            String word = wordList.get(i);
            List<Integer> neighbours = graph.get(i);
            System.out.println("word : " + word +" , i : "+ i +  " has neighbours : " + neighbours);
           
        }
        
    }
    
    private void addInPatern(Map<String, Set<String>> map, String word, int m) {
        System.out.println("all patterns for word : " + word);
        for(int i = 0 ; i < m ; i++){
            String pattern = word.substring(0, i) + "*" + word.substring(i+1, m);
            Set<String> words = map.get(pattern);
            if(words == null){
                Set<String> st = new HashSet<>(); 
                st.add(word);
                map.put(pattern, st);
            }else{
                words.add(word);
                map.put(pattern, words);
            }
            System.out.println("pattern : " + pattern);
        }
    }

    private int findShortedDistance(List<List<Integer>> graph, Integer startIndex ,Integer endIndex){

        boolean[] visited = new boolean[graph.size()];
        int value = 0, step = 0, minStep = 0;

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{startIndex, 1});
        visited[startIndex] = true;

        while(!queue.isEmpty()){
            Integer[] top = queue.poll();
            value = top[0]; step = top[1];
            System.out.println("value : " + value + " and step : " + step);
            if(value == endIndex){
                minStep = step;
                break;
            }

            for(int neighbour : graph.get(value)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(new Integer[]{neighbour, step +1});
                }
            }
        }

        return minStep;
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();

        if(!wordList.contains(beginWord)){
            wordList.add(0, beginWord);   
        }
        if(!wordList.contains(endWord)){
            return 0; 
        }

        int n = wordList.size(), m = wordList.get(0).length();
        for(int i = 0 ; i < n ; i++){
            addInPatern(map, wordList.get(i), m);
        }

        map.forEach(
            (k, v) -> {
                System.out.println("k : " + k + " has patterns : " + v);
            }
        );

        Map<String, Integer> wordIndex = new HashMap<>();
        for(int i = 0 ; i < wordList.size() ; i++){
            String word = wordList.get(i);
            wordIndex.put(word, i);
        }


        List<List<Integer>> graph = new ArrayList<>();
        createGraph(map, m, wordIndex, graph, wordList);

        int minStep = findShortedDistance(graph, wordIndex.get(beginWord), wordIndex.get(endWord));

        return minStep;
    }
}