1class Solution {
2
3    public int kthSmallest(int[][] matrix, int k) {
4        
5        Queue<int[]> minHeap = new PriorityQueue<>(
6            (int[] a, int[] b) -> {
7                return Integer.compare(matrix[a[0]][a[1]], matrix[b[0]][b[1]]); 
8            }
9        );
10
11        int n = matrix.length, m = matrix[0].length;
12        for(int i = 0 ; i < Math.min(k, n) ; i++){
13            minHeap.add(new int[]{i, 0});
14        }
15
16        int r = 0, c = 0;
17        int[] tmp;
18        while(k > 0 && !minHeap.isEmpty()){
19            tmp = minHeap.poll();
20            r = tmp[0]; c = tmp[1]; k--;
21
22            if(c + 1 < m){
23                minHeap.add(new int[]{r, c + 1});
24            }
25        }
26
27        return matrix[r][c];
28
29    }
30}