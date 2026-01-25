1class Solution {
2    public int[][] merge(int[][] intervals) {
3        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
4
5        int index = 0;
6        int n = intervals.length;
7        List<int[]> list = new ArrayList<>();
8        
9
10        while(index < n){
11            int start = intervals[index][0];
12            int end = intervals[index][1];
13            while(index + 1 < n && intervals[index+1][0] <= end){
14                end = Math.max(end, intervals[index+1][1]);
15                index++;
16            }
17            list.add(new int[]{start, end});
18            index++;
19        }
20        int[][] ans = new int[list.size()][2];
21        for(int i = 0 ; i < list.size(); i++){
22            ans[i] = list.get(i);
23        }
24        return ans;
25    }
26}