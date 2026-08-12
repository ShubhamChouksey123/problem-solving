class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        List<int[]> mergedIntervals = new ArrayList<>();
        
        int start = 0, end = 0, n = intervals.length;
        while(start < n){
            end = start;
            int intervalEnd = intervals[end][1];
            while(end + 1 < n && intervals[end + 1][0] <= intervalEnd){
                end++;
                intervalEnd = Math.max(intervalEnd, intervals[end][1]);
            }

            mergedIntervals.add(new int[]{intervals[start][0], intervalEnd});
            start = end + 1;
        }
        
        int[][] ans = new int[mergedIntervals.size()][2];
        for(int i = 0 ; i < mergedIntervals.size() ; i++){
            ans[i] = mergedIntervals.get(i);
        }
        return ans;
    }
}