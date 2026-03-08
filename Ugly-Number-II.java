1class Solution {
2    public int nthUglyNumber(int n) {
3
4        Queue<Long> minHeap = new PriorityQueue<>();
5        minHeap.add(1L);
6        Set<Long> visited = new HashSet<>();
7
8        Long num = 1L;
9        while(n > 0){
10            num = minHeap.poll();
11            if(visited.contains(num)){
12                continue;
13            }
14            visited.add(num);
15            minHeap.add(num*2);
16            minHeap.add(num*3);
17            minHeap.add(num*5); n--;
18        }
19        return num.intValue();
20    }
21}