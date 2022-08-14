class Solution {

    public static int edgeScore(int[] edges) {
        int n = edges.length;
        Map<Integer, Long> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer start = i;
            Integer end = edges[i];
            Long currentSum = mp.get(end);
            if(currentSum == null){
                currentSum = Long.valueOf(0);
            }
            mp.put(end, currentSum + start);
        }

        Integer maxSumElement = 0;
        Long maxSum = Long.valueOf(0);
        for(Map.Entry<Integer, Long> element : mp.entrySet()){
            if(element.getValue() > maxSum ){
                maxSum = element.getValue();
                maxSumElement = element.getKey();
            }
        }

        return maxSumElement;
    }

    
}