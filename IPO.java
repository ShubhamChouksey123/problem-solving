1class Solution {
2    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
3
4        PriorityQueue<Integer[]> lowestCapitals = new PriorityQueue<>(
5                (Integer[] a, Integer[] b) -> {
6                    return a[0] - b[0];
7                }
8        );
9
10        int n = profits.length;
11        for (int i = 0; i < n; i++) {
12
13            Integer[] temp = new Integer[]{capital[i], profits[i]};
14            lowestCapitals.add(temp);
15        }
16
17        PriorityQueue<Integer> maximumProfits = new PriorityQueue<>((a, b) -> b - a);
18
19        int totalProfit = 0;
20        while (k-- > 0) {
21            while (!lowestCapitals.isEmpty() && lowestCapitals.peek()[0] <= w) {
22                Integer[] lowestCapital = lowestCapitals.poll();
23                maximumProfits.add(lowestCapital[1]);
24            }
25
26            if (!maximumProfits.isEmpty()) {
27                w += maximumProfits.poll();
28            }
29        }
30
31        return w;
32    }
33}