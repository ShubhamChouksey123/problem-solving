class Solution {

    public class maxComparator implements Comparator<Integer[]> {

        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            if (Objects.equals(o1[1], o2[1])) {
                return o1[0].compareTo(o2[0]);
            }
            return o2[1].compareTo(o1[1]);
        }
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;

        Integer[][] arr = new Integer[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }

        Arrays.sort(arr, new maxComparator());
        // System.out.println("arr : " + Arrays.deepToString(arr));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long sum = 0;
        for (int i = 0; i < k; i++) {
            pq.add(arr[i][0]);
            sum += arr[i][0];
        }

        long score = sum * arr[k - 1][1];
        long maxScore = score;


        for (int i = k; i < n; i++) {
            int topElement = pq.poll();
            sum = sum - topElement + arr[i][0];
            score = sum * arr[i][1];
            maxScore = Math.max(maxScore, score);
            pq.add(arr[i][0]);
        }
        return maxScore;
    }
}