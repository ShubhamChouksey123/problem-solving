class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> counts = new HashMap<>();
        for(String word : words){
            Integer presentCount = counts.get(word);
            if(presentCount == null){
                counts.put(word, 1);
            }else{
                counts.put(word, presentCount + 1);
            }
        }

        Queue<String[]> pq = new PriorityQueue<>(
            (String[] a, String[] b) -> {
                if(Integer.valueOf(a[1]) != Integer.valueOf(b[1]) ){
                    return Integer.valueOf(a[1]) - Integer.valueOf(b[1]);
                }
                return b[0].compareTo(a[0]);
            }
        );


        for(Map.Entry<String, Integer> entry : counts.entrySet()){
            String[] element = new String[]{entry.getKey(), entry.getValue().toString()};
            pq.add(element);
            if(pq.size() > k){
                pq.poll();
            }
        }


        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            String[] element = pq.poll();
            ans.add(element[0]);
        }
        Collections.reverse(ans);

        return ans;
    }
}