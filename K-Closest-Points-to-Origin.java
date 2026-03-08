1class Solution {
2    public int[][] kClosest(int[][] points, int k) {
3
4        Queue<int[]> maxHeap = new PriorityQueue<>(
5            (int[] a, int[] b) -> {
6                return Integer.compare((b[0] * b[0]) + b[1] * b[1], (a[0] * a[0] + a[1] * a[1]));
7            }    
8        );
9
10        for(int[] point : points){
11            maxHeap.add(new int[]{point[0], point[1]});
12            if(maxHeap.size() > k){
13                maxHeap.poll();
14            }
15        }
16        
17        int[][] ans = new int[k][2];
18        int i = 0;
19        while(!maxHeap.isEmpty()){
20            int[] element = maxHeap.poll();
21            ans[i][0] = element[0]; ans[i][1] = element[1]; i++;
22        }
23
24        return ans;
25        
26    }
27}