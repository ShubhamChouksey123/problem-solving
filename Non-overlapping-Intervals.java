1class Solution {
2
3    public int eraseOverlapIntervals(int[][] intervals) {
4
5
6        Arrays.sort(intervals, 
7            (int[] a, int[] b) -> 
8                {
9                    if(a[1] != b[1]){
10                        return Integer.compare(a[1], b[1]);
11                    }    
12                    return Integer.compare(a[0], b[0]);
13                }
14        );
15
16        int index = 0, n = intervals.length, count = 0;
17
18        while(index < n){
19            int startMin = intervals[index][0];
20            int endMin = intervals[index][1];
21            while(index + 1 < n && intervals[index+ 1][0] < endMin){
22                count++;
23                index++;
24            }
25            index++;
26        }
27        return count;
28        
29    }
30}