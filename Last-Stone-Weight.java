1class Solution {
2    public int lastStoneWeight(int[] stones) {
3        
4        Queue<Integer> pq = new PriorityQueue<>(
5            (a, b) -> Integer.compare(b, a)
6        );
7
8        for(int stone : stones){
9            pq.add(stone);
10        }
11
12        while(pq.size() > 1){
13            int x = pq.poll();
14            int y = pq.poll();
15
16            if(x > y){
17                pq.add(x - y);
18            }
19        }
20
21        if(pq.size() == 1){
22            return pq.poll();
23        }
24        return 0;
25    }
26}