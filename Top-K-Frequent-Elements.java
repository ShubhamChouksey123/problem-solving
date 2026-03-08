1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3        Map<Integer, Integer> freq = new HashMap<>();
4        for(int num : nums){
5            freq.put(num, freq.getOrDefault(num, 0) + 1);
6        }    
7
8        // freq => value 
9        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
10            (int[] a, int[] b) -> {
11                return Integer.compare(a[0], b[0]);
12            }    
13        );
14
15        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
16            minHeap.add(new int[]{entry.getValue(), entry.getKey()});
17            if(minHeap.size() > k){
18                minHeap.poll();
19            }
20        }
21
22        int[] ans = new int[k]; int i = 0 ;
23        while(!minHeap.isEmpty()){
24            ans[i] = minHeap.poll()[1]; i++;
25        }
26        
27        return ans;
28    }
29}