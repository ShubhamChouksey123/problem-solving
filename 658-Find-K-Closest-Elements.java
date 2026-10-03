class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int n = arr.length;
        // postive numbers
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        // negative numbers
        Queue<Integer> minHeap = new PriorityQueue<>();
        
        
        for(int i = 0 ; i < n ; i++){
            int num = arr[i] - x;
            if(num >= 0){
                maxHeap.add(num);
                if(maxHeap.size() > k) maxHeap.poll();
            }
            else{
                minHeap.add(num);
                if(minHeap.size() > k) minHeap.poll();
            }
        }

        while(maxHeap.size() + minHeap.size() > k){
            if(Math.abs(maxHeap.peek()) < Math.abs(minHeap.peek())){
                minHeap.poll();
            }
            else{
                maxHeap.poll();
            }
        }  

        List<Integer> ans = new ArrayList<>();
        while(!minHeap.isEmpty()){
            int num = x + minHeap.poll();
            ans.add(num);
        }
        while(!maxHeap.isEmpty()){
            int num = x + maxHeap.poll();
            ans.add(num);
        } 
        Collections.sort(ans);
        return ans;    
    }
}