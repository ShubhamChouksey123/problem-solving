class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;
        Map<Integer, Integer> numToFrequency = new HashMap<>();
        for(int num : nums){
            numToFrequency.put(num, numToFrequency.getOrDefault(num, 0) + 1);
        }

        /**
            element containing {num, frequency}
         */
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for(Map.Entry<Integer, Integer> entry : numToFrequency.entrySet()){
            Integer num = entry.getKey();
            Integer freq = entry.getValue();
            minHeap.add(new int[]{num, freq});
            if(minHeap.size() > k) minHeap.poll();
        }

        int[] ans = new int[k];
        int index = 0;

        while(!minHeap.isEmpty()){
            ans[index] = minHeap.poll()[0];
            index++;
        }
        return ans;
    }
}