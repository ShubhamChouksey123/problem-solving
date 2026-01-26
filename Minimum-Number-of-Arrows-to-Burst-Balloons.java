1class Solution {
2
3
4    public int findMinArrowShots(int[][] points) {
5        int n = points.length;
6        
7        Arrays.sort(points, 
8            (int[] a, int[] b) -> {
9                if(a[0] != b[0]){
10                    return (a[0] < b[0]) ? -1 : 1;
11                }
12                return (a[1] < b[1]) ? -1 : 1;
13            } 
14        );
15        
16        int count = 0;
17        int index = 0;
18
19        while(index < n){
20            int currentStart = points[index][0];
21            int currentEnd = points[index][1];
22
23            while(index+1 < n && points[index+1][0] <= currentEnd){
24                index++;
25                currentStart = Math.max(currentStart, points[index][0]);
26                currentEnd = Math.min(currentEnd, points[index][1]);
27
28            }
29            count++;
30            index++;
31        }
32
33        return count;    
34    }
35}