1class Solution {
2    public int[] smallestRange(List<List<Integer>> nums) {
3
4        int n = nums.size();
5        Queue<int[]> minHeap = new PriorityQueue<>(
6            (a, b) -> Integer.compare(a[2], b[2])
7        );
8
9        int currentSetMax = Integer.MIN_VALUE;
10        for(int i = 0 ; i < n ; i++){
11            currentSetMax = Math.max(currentSetMax, nums.get(i).get(0));
12            minHeap.add(new int[]{i, 0, nums.get(i).get(0)});
13        }
14
15        int range = Integer.MAX_VALUE;
16        int minRange = Integer.MAX_VALUE;
17        int[] ans = new int[2];
18
19        while(!minHeap.isEmpty()){
20
21            int[] minElement = minHeap.poll();
22            int index = minElement[0];
23            int currentIndex = minElement[1];
24            range = currentSetMax - minElement[2];
25            if(range < minRange){
26                minRange = range;
27                ans[0] = minElement[2];
28                ans[1] = currentSetMax;
29            }
30            
31            if(currentIndex + 1 == nums.get(index).size()) break;
32
33            currentSetMax = Math.max(currentSetMax, nums.get(index).get(currentIndex + 1));
34            minHeap.add(new int[]{index, currentIndex + 1, nums.get(index).get(currentIndex + 1)});
35        }
36        return ans;
37    }
38}