class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        int n = arr.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < Math.min(k, n); i++) {
            int maxResults = k;
            for (int j = n - 1; j >= 0 && maxResults >= 0 && i != j; j--, maxResults--) {
                double currentValue = (double) arr[i] / arr[j];
                if (pq.size() < k) {
                    pq.add(new Pair(currentValue, arr[i], arr[j]));
                    continue;
                }
                Pair top = pq.peek();
                double topValue = top.fraction;
                if (currentValue < topValue) {
                    pq.poll();
                    pq.add(new Pair(currentValue, arr[i], arr[j]));
                }
            }
        }

        Pair current = pq.peek();
        return new int[]{current.a, current.b};

    }


    public class Pair implements Comparable<Pair> {
        double fraction;
        int a;
        int b;

        public Pair(double fraction, int a, int b) {
            this.fraction = fraction;
            this.a = a;
            this.b = b;
        }


        @Override
        public int compareTo(Pair o) {
            if (this.fraction > o.fraction) {
                return 1;
            }
            return -1;
        }
    }
}