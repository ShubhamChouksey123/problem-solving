class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        int n = intervals.length;

        Arrays.sort(intervals, 
            (a, b) -> {
                if(a[0] != b[0]) 
                    return Integer.compare(a[0], b[0]);
                return Integer.compare(b[1], a[1]);
            }
        );
        

        int start = 0, end = 0;
        int nonOverlapInterval = 0;

        while(start < n){
            end = start;
            while(end + 1 < n && intervals[start][1] >= intervals[end + 1][1]){
                end++;
            }
            nonOverlapInterval++;
            start = end + 1;
        }

        return nonOverlapInterval;
    }
}