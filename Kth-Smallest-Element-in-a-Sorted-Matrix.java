1class Solution {
2    public int kthSmallest(int[][] matrix, int k) {
3
4        int n = matrix.length, m = matrix[0].length;
5        Queue<int[]> minHeap = new PriorityQueue<>(
6            (a, b) -> {
7                return Integer.compare(a[2], b[2]);
8            }
9        );
10
11        for(int i = 0 ; i < n && i < k ; i++){
12            minHeap.add(new int[]{i, 0, matrix[i][0]});
13        }
14        
15        int element = 0;
16        while(k > 0 && !minHeap.isEmpty()){
17            int[] top = minHeap.poll();
18            int row = top[0], column = top[1]; 
19            element = top[2];
20            k--;
21            if(column + 1 < m){
22                minHeap.add(new int[]{row, column + 1, matrix[row][column + 1]});
23            }
24        }
25        return element;
26    }
27}