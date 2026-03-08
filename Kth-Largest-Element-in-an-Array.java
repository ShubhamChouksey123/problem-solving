1class Solution {
2    public int findKthLargest(int[] nums, int k) {
3        Queue<Integer> minHeap = new PriorityQueue<>();
4
5        for(int num : nums){
6            minHeap.add(num);
7            if(minHeap.size() > k){
8                minHeap.poll();
9            }
10        }
11        return minHeap.peek();
12    }
13}