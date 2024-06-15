class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue<Integer[]> lowestCapitals = new PriorityQueue<>(
                (Integer[] a, Integer[] b) -> {
                    return a[0] - b[0];
                }
        );

        int n = profits.length;
        for (int i = 0; i < n; i++) {

            Integer[] temp = new Integer[]{capital[i], profits[i]};
            lowestCapitals.add(temp);
        }

        PriorityQueue<Integer> maximumProfits = new PriorityQueue<>((a, b) -> b - a);

        int totalProfit = 0;
        while (k-- > 0) {
            while (!lowestCapitals.isEmpty() && lowestCapitals.peek()[0] <= w) {
                Integer[] lowestCapital = lowestCapitals.poll();
                maximumProfits.add(lowestCapital[1]);
            }

            if (!maximumProfits.isEmpty()) {
                w += maximumProfits.poll();
            }
        }

        return w;
    }
}