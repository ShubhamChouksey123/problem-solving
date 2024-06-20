class Solution {
    public int longestConsecutive(int[] nums) {

        Queue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
        }    

        int lastElement = Integer.MAX_VALUE;
        int count = 0;
        int maxCount = 0;
        while(!pq.isEmpty()){
            int top = pq.poll();
            if(top == lastElement){
            }
            else if(top - lastElement == 1){
                count++;
            }else{
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
            lastElement = top;
        }

        return maxCount;
    }
}