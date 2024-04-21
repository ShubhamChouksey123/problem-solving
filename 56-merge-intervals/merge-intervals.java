class Solution {

     private int[][] convertListToArray(List<List<Integer>> mergedIntervals){

        int length = mergedIntervals.size();
        int[][] mergedAns = new int[length][2];

        for(int i = 0 ; i < length; i++){
            mergedAns[i][0] = mergedIntervals.get(i).get(0);
            mergedAns[i][1] = mergedIntervals.get(i).get(1);
        }

        return mergedAns;
    }
    public int[][] merge(int[][] intervals) {

        List<List<Integer>> mergedIntervals = new ArrayList<>();

        int n = intervals.length;
        if (n <= 1)
            return intervals;
        
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int index = 0;
        while (index < n) {

            int startLast = intervals[index][0];
            int endLast = intervals[index][1];

            while (index + 1 < n && intervals[index + 1][0] <= endLast) {
                index++;
                int start = intervals[index][0];
                int end = intervals[index][1];

                startLast = Math.min(startLast, start);
                endLast = Math.max(endLast, end);

            }

            List<Integer> interval = new ArrayList<>();
            interval.add(startLast);
            interval.add(endLast);
            mergedIntervals.add(interval);
            index++;
        }

        // System.out.println("mergedIntervals : " + mergedIntervals);

        int[][] mergedAns = convertListToArray( mergedIntervals );

        return mergedAns;
        
    }
}