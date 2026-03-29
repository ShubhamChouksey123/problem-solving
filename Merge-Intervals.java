1class Solution {
2    public int[][] merge(int[][] intervals) {
3
4        Arrays.sort(intervals, 
5            (int[] a, int[] b) -> {
6                if(a[0] != b[0]){
7                    return Integer.compare(a[0], b[0]);
8                }
9                return Integer.compare(a[1], b[1]);
10            } 
11        );
12
13        int n = intervals.length;
14        int start = 0, end = 0;
15        List<int[]> mergedIntervals = new ArrayList<>();
16
17        while(start < n){
18            end = start;
19            int startTime = intervals[start][0];
20            int endTime = intervals[start][1];
21            while( end + 1 < n && endTime >= intervals[end + 1][0] ){
22                end = end + 1;
23                endTime = Math.max(endTime, intervals[end][1]);
24            }
25            mergedIntervals.add(new int[]{startTime, endTime});
26            start = end + 1;
27        }
28
29        int[][] ans = new int[mergedIntervals.size()][2];
30
31        int i = 0;
32        for(int[] mergedInterval : mergedIntervals){
33            ans[i] = mergedInterval; i++;
34        }
35        return ans;
36        
37    }
38}