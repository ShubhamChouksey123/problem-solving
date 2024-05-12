class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        int n = quality.length;
        Double[][] arr = new Double[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = (double) quality[i];
            arr[i][1] = (double) wage[i];
            arr[i][2] = (double) wage[i] / (double) quality[i];

        }

        Arrays.sort(arr, new WagerComparator());
        System.out.println("arr : " + Arrays.deepToString(arr));

        PriorityQueue<Double> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        double totalQuality = 0;
        for (int i = 0; i < k; i++) {
            totalQuality = totalQuality + arr[i][0];
            maxPQ.add(arr[i][0]);
        }

        double amount = totalQuality * arr[k - 1][2];
        double maxAmount = amount;

        for (int i = k; i < n; i++) {
            totalQuality = totalQuality - maxPQ.poll() + arr[i][0];
            amount = totalQuality * arr[i][2];
            maxAmount = Math.min(amount, maxAmount);
            maxPQ.add(arr[i][0]);
        }


        return maxAmount;
    }

    public class WagerComparator implements Comparator<Double[]> {

        @Override
        public int compare(Double[] o1, Double[] o2) {
            if (Objects.equals(o1[2], o2[2])) {
                return o1[0].compareTo(o2[0]);
            }
            return o1[2].compareTo(o2[2]);
        }
    }
}