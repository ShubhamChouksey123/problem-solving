1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3
4        Map<Integer, Integer> frequencyOrNum = new HashMap<>();
5        for(int num : nums){
6            frequencyOrNum.put(num, frequencyOrNum.getOrDefault(num, 0) + 1);   
7        }
8
9        Queue<int[]> topKElements = new PriorityQueue<>(
10            (a, b) -> {
11                return Integer.compare(a[1], b[1]);
12            }
13        );
14
15        for(Map.Entry<Integer, Integer> entry : frequencyOrNum.entrySet()){
16            int num = entry.getKey();
17            int times = entry.getValue();
18            topKElements.add(new int[]{num, times});
19
20            if(topKElements.size() > k){
21                topKElements.poll();  
22            }
23        }
24
25        int[] ans = new int[k]; int i = 0;
26        while(!topKElements.isEmpty()){
27            ans[i++] = topKElements.poll()[0];
28        }
29
30        return ans;
31    }
32}