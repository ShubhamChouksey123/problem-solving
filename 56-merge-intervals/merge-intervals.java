class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (int[] a, int[] b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];  
            }
            return a[1] - b[1];
        });
        
        int index = 0, n = intervals.length;
        List<Integer[]> mergedIntervals = new ArrayList<>();

        while(index < n){
            
            int start = intervals[index][0];
            int end = intervals[index][1];

            // overlapping interval
            while(index+1 < n && intervals[index+1][0] <= end){
                index++;
                end = Math.max(end, intervals[index][1]);
            }

            mergedIntervals.add(new Integer[]{start, end});
            index++;
        }

        int[][] ans = new int[mergedIntervals.size()][2];
        index = 0;

        for(Integer[] interval : mergedIntervals){
            ans[index][0] = interval[0];
            ans[index][1] = interval[1];
            index++;
        }

        // System.out.println("");
        return ans;
    }
}