1class Solution {
2
3    private int[][] convertToArray(List<List<Integer>> intervals){
4
5        int[][] ans = new int[intervals.size()][2];
6        int i = 0;
7        for(List<Integer> interval : intervals){
8            ans[i][0] = interval.get(0); ans[i][1] = interval.get(1);
9            i++;
10        }
11        return ans;
12    }
13
14    private boolean isOverlapping(int[] intervalA, int[] intervalB){
15        if(intervalA[0] <= intervalB[1] && intervalB[0] <= intervalA[1]){
16            return true;
17        }
18        return false;
19    }
20
21    public int[][] insert(int[][] intervals, int[] newInterval) {
22
23        int n = intervals.length;
24        List<List<Integer>> mergedIntervals = new ArrayList<>();
25        int index = 0;
26
27        while(index < n && intervals[index][1] < newInterval[0]){
28            mergedIntervals.add(List.of(intervals[index][0], intervals[index][1])); 
29            index++;
30        }
31
32        while(index < n){
33            if(!isOverlapping(newInterval, intervals[index])){
34                break;
35            }
36            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
37            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
38            index++;
39        }
40
41        mergedIntervals.add(List.of(newInterval[0], newInterval[1]));
42
43        while(index < n){
44           mergedIntervals.add(List.of(intervals[index][0], intervals[index][1])); 
45           index++; 
46        } 
47
48        return convertToArray(mergedIntervals);
49    }
50}