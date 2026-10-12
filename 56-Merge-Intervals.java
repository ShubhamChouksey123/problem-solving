class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> mergedIntervals = new ArrayList<>();
        int n = intervals.length;
        int start = 0, end = 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        while(start < n){
            int minValue = intervals[start][0];
            int maxValue = intervals[start][1];
            end = start;
            while(end + 1 < n && maxValue >= intervals[end + 1][0]){
                end = end + 1;
                maxValue = Math.max(maxValue, intervals[end][1]);
            }
            mergedIntervals.add(new int[]{minValue, maxValue});   
            start = end + 1;
        }

        int[][] ans = new int[mergedIntervals.size()][2];

        for(int i = 0 ; i < mergedIntervals.size() ; i++){
            ans[i] = mergedIntervals.get(i);
        }
        return ans;        
    }
}