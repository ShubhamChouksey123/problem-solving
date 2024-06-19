class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals , (a, b) -> {
            if(a[0] != b[0]){
                return a[0] -  b[0];
            }
            return a[1] - b[1];
        });

        // System.out.println("intervals : " + Arrays.deepToString(intervals));

        int prevStart = Integer.MIN_VALUE;
        int prevEnd = Integer.MIN_VALUE;

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            if(intervals[i][0] == prevStart){
                continue;
            }
            list.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
            prevStart = intervals[i][0];
        }

        // System.out.println("list : " + list);


        prevStart = list.get(0).get(0);
        prevEnd = list.get(0).get(1);
        int count = n - list.size();
        // System.out.println("count : " + count);

        for(int i = 1 ; i < list.size() ; i++){
            int currentStart = list.get(i).get(0);
            int currentEnd = list.get(i).get(1);
            // System.out.println("prevStart : " + prevStart + ", prevEnd : " + prevEnd + " and currentStart : " + currentStart + ", currentEnd : " + currentEnd);
            if(currentStart < prevEnd){
                count++;
            }
            // non overlapping
            if(currentStart >= prevEnd){
                prevStart = currentStart;
                prevEnd = currentEnd;
                continue;
            }

            // overlapping
            if(currentEnd < prevEnd){
                prevStart = currentStart;
                prevEnd = currentEnd;
            }

        }

        return count;
    }
}