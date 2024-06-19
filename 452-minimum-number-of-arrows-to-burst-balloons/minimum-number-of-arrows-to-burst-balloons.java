class Solution {


    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        
        Arrays.sort(points, 
            (int[] a, int[] b) -> {
                if(a[0] != b[0]){
                    return (a[0] < b[0]) ? -1 : 1;
                }
                return (a[1] < b[1]) ? -1 : 1;
            } 
        );
        
        int count = 0;
        int index = 0;

        while(index < n){
            int currentStart = points[index][0];
            int currentEnd = points[index][1];

            while(index+1 < n && points[index+1][0] <= currentEnd){
                index++;
                currentStart = Math.max(currentStart, points[index][0]);
                currentEnd = Math.min(currentEnd, points[index][1]);

            }
            count++;
            index++;
        }

        return count;    
    }
}