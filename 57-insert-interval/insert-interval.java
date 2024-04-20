class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

         int n = intervals.length;
        // if(n == 0){
        //     return intervals;
        // }

        int startI = newInterval[0];
        int endI = newInterval[1];

        int startMin = startI;
        int endMax = endI;

        int length = 0;

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (endI < start || end < startI) {
                length++;
            }


            if (startI >= start && startI <= end) {
                startMin = Math.min(startMin, start);
            }

            if (endI >= start && endI <= end) {
                endMax = Math.max(endMax, end);
            }
        }

        int[][] intervalsModified = new int[length + 1][2];

        int index = 0;
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (end < startI) {
                intervalsModified[index] = intervals[i];
                index++;
            }

        }

        intervalsModified[index] = new int[]{startMin, endMax};
        index++;

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (endI < start) {
                intervalsModified[index] = intervals[i];
                index++;
            }

        }


        System.out.println("startMin : " + startMin + " & endMax : " + endMax);
        // print(intervalsModified);
        return intervalsModified;
        
    }
}