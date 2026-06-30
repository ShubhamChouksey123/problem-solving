1class Solution {
2    public int findKthLargest(int[] nums, int k) {
3
4        Queue<Integer> largestElementBucket = new PriorityQueue<>();
5
6        for(int num : nums){
7            largestElementBucket.add(num);
8            if(largestElementBucket.size() > k) largestElementBucket.poll();
9        }
10
11        return largestElementBucket.peek();
12    }
13}