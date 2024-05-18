class Solution {
    private int maxCount = 0;
   
     private String getSlopeBetweenTwoPoints(int[][] points, int index1, int index2) {

        int x1 = points[index1][0];
        int y1 = points[index1][1];

        int x2 = points[index2][0];
        int y2 = points[index2][1];

        if (x1 == x2) {
            return "inf";
        }
        return String.valueOf(((double)y2 - y1) / ((double)x2 - x1));
    }

    private int getCountOfSameSlopePoints(int[][] points, int n, int index) {

        Map<String, Integer> countNumber = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (i == index)
                continue;

            String slope = getSlopeBetweenTwoPoints(points, index, i);
            Integer oldCount = countNumber.get(slope);
            if (oldCount == null) {
                countNumber.put(slope, 2);
                maxCount = Math.max(2, maxCount);
            } else {
                countNumber.put(slope, oldCount + 1);
                maxCount = Math.max(oldCount + 1, maxCount);
            }

        }

        return 0;
    }

    public int maxPoints(int[][] points) {

        int n = points.length;
        if (n <= 1)
            return 1;

        for (int i = 0; i < n; i++) {
            getCountOfSameSlopePoints(points, points.length, i);
        }

        return maxCount;
    }

}