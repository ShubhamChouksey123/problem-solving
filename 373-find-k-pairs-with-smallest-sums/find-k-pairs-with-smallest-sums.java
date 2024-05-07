class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {


        int m = nums1.length;
        int n = nums2.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(((int[] a, int[] b) -> ((b[0] + b[1]) - (a[0] + a[1]))));

        for (int i = 0; i < Math.min(m, k); i++) {
            for (int j = 0; j < Math.min(n, k); j++) {

                if (pq.size() < k) {
                    int[] pair = new int[]{nums1[i], nums2[j]};
                    pq.add(pair);
                    continue;
                }

                int[] topSmallPair = pq.peek();

                if (topSmallPair[0] + topSmallPair[1] > nums1[i] + nums2[j]) {
                    pq.poll();
                    int[] pair = new int[]{nums1[i], nums2[j]};
                    pq.add(pair);
                }

            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            List<Integer> pair = new ArrayList<>();
            int[] topSmallPair = pq.poll();
            pair.add(topSmallPair[0]);
            pair.add(topSmallPair[1]);
            ans.add(pair);
        }

        return ans;
    }
}