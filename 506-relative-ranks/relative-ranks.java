class Solution {
     public String[] findRelativeRanks(int[] score) {

        int n = score.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> (a[0] - b[0]));

        for (int i = 0; i < n; i++) {
            int[] element = new int[]{score[i], i};
            pq.add(element);
        }


        String[] ans = new String[n];
        int rank = n;
        while (!pq.isEmpty()) {
            int[] element = pq.poll();
            int index = element[1];
            ans[index] = String.valueOf(rank);
            if (rank == 3) {
                ans[index] = "Bronze Medal";
            } else if (rank == 2) {
                ans[index] = "Silver Medal";
            } else if (rank == 1) {
                ans[index] = "Gold Medal";
            }
            rank--;
        }


        return ans;
    }

}