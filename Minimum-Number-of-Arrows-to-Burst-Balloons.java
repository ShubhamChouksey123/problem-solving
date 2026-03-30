1class Solution {
2    public int findMinArrowShots(int[][] points) {
3        
4        Arrays.sort(points, 
5            (int[] pointA, int[] pointB) -> {
6                if(pointA[1] != pointB[1]){
7                    return Integer.compare(pointA[1], pointB[1]);
8                }
9                return Integer.compare(pointA[0], pointB[0]);
10            }
11        );
12
13        int n = points.length;
14        int index = 0, countArrows = 0;
15
16        while(index < n){
17            int start = points[index][0];
18            int end   = points[index][1];
19             
20            while(index + 1 < n && end >= points[index + 1][0]){
21                index++;
22            }
23            countArrows++;
24            index++;
25        }
26        return countArrows;
27    }
28}