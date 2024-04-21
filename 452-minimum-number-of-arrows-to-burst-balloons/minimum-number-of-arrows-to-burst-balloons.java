class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(points));
        int count = 0;

        int index = 0;
        while (index < n) {
            int startMax = points[index][0];
            int endMin = points[index][1];

            while (index + 1 < n && points[index + 1][0] <= endMin) {
                index++;
                startMax = Math.max(startMax, points[index][0]);
                endMin = Math.min(endMin, points[index][1]);
            }
            count++;
            index++;
        }

        return count;
        
    }
}