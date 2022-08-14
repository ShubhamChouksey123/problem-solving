class Solution {
    
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = 0 ; i < stones.length ; i++){
            pq.add(stones[i]);
        }
        
        
        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();
            
            if(x < y)
                pq.add(y-x);
        }
        if(pq.size() == 1){
            return pq.peek().intValue();    
        }
        return 0;
                
    }
}
/*

[2,7,4,1,8,1]
[1]
[1, 2]
[4, 9]
[1, 1000]
[1000, 1000, 99, 80]
*/