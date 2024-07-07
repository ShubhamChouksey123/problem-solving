class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        /**
        map of number and its frequncy
         */
        Map<Integer, Integer> numCounts = new HashMap<>();

        for(int num : nums) {
            Integer currentCount = numCounts.get(num);
            if(currentCount == null){
                numCounts.put(num, 1);
            }else{
                numCounts.put(num, 1+currentCount);
            }
        }

        Queue<Integer[]> pq = new PriorityQueue<>(
            (Integer[] a, Integer[] b) -> {
                return a[0] -  b[0];
            }
        );


        for(Map.Entry<Integer, Integer> entry : numCounts.entrySet()){
            Integer[] element = new Integer[]{entry.getValue(), entry.getKey()};

            if(pq.size() < k){
                pq.add(element);
                continue;
            }
            
            Integer[] top = pq.peek();

            if(entry.getValue() > top[0]){
                // System.out.println("removed the element : " +  top[1]);
                pq.poll();
                pq.add(element);
            }
           
        }

        int[] ans = new int[k];
        int index = 0;
        while(!pq.isEmpty()){
            Integer[] top = pq.poll();
            ans[index] = top[1];
            index++;
        }
        return ans;
    }
}