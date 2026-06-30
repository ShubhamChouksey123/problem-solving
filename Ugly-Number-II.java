1class Solution {
2    public int nthUglyNumber(int n) {
3
4        Queue<Long> pq = new PriorityQueue<>();
5        pq.add(1l);
6        int index = 0;
7
8        long num = 0;
9        while(index < n){
10            long topElement = pq.poll();
11            if(topElement <= num){
12                continue;
13            }
14            index++; num = topElement;
15            pq.add(num * 2l);
16            pq.add(num * 3l);
17            pq.add(num * 5l);
18        }
19
20        return (int)num;
21    }
22}