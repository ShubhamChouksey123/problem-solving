class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue<Integer[]> minPQ = new PriorityQueue<>((Integer[] a, Integer[] b) -> a[0] - b[0]);

        int n = profits.length;
        for (int i = 0; i < n; i++) {
            minPQ.add(new Integer[]{capital[i], profits[i]});
        }


        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((Integer a, Integer b) -> (b - a));
        int times = k;
        while (times-- > 0) {

            while (!minPQ.isEmpty() && minPQ.peek()[0] <= w) {
                Integer[] top = minPQ.poll();
                int c = top[0];
                int profit = top[1];
                maxPQ.add(profit);
            }

            if (!maxPQ.isEmpty()) {
                w += maxPQ.poll();
            }
        }

        System.out.println("minPQ : " + minPQ);
        System.out.println("w : " + w);

        return w;
    }
}