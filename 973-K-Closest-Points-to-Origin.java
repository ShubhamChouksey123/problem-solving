class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        Queue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                
                return Integer.compare( ((b[0] * b[0]) + (b[1] * b[1])),   (a[0] * a[0]) + (a[1] * a[1]) );
            }
        );
        
        for(int[] point : points){
            maxHeap.add(new int[]{point[0], point[1]});
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        
        int[][] ans = new int[k][2];
        int index = 0;
        while(!maxHeap.isEmpty()){
            int[] point = maxHeap.poll();
            ans[index][0] = point[0];
            ans[index][1] = point[1];
            index++;
            
        }
        return ans;
    }
} 