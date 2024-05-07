class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {


        int m = nums1.length;
        int n = nums2.length;

        PriorityQueue<SmallPair> pq = new PriorityQueue<>(new SmallPairMaxComparator());

        for (int i = 0; i < Math.min(m, k); i++) {
            for (int j = 0; j < Math.min(n, k); j++) {

                if (pq.size() < k) {
                    pq.add(new SmallPair(nums1[i], nums2[j]));
                    continue;
                }

                SmallPair topSmallPair = pq.peek();

                if (topSmallPair.getSum() > nums1[i] + nums2[j]) {
                    pq.poll();
                    pq.add(new SmallPair(nums1[i], nums2[j]));
                }

                // System.out.println("after adding " + nums1[i] + " and " + nums2[j] + " pq.peek : " + pq.peek());
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            List<Integer> pair = new ArrayList<>();
            SmallPair topSmallPair = pq.poll();
            pair.add(topSmallPair.getA());
            pair.add(topSmallPair.getB());
            ans.add(pair);
        }

        return ans;
    }

    public class SmallPairMinComparator implements Comparator<SmallPair> {

        @Override
        public int compare(SmallPair o1, SmallPair o2) {
            return (o1.getA() + o1.getB()) - (o2.getA() + o2.getB());
        }
    }

    public class SmallPairMaxComparator implements Comparator<SmallPair> {

        @Override
        public int compare(SmallPair o1, SmallPair o2) {
            return (o2.getA() + o2.getB()) - (o1.getA() + o1.getB());
        }
    }

    public class SmallPair {
        public int a;
        public int b;

        public SmallPair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getSum() {
            return this.getA() + this.getB();
        }

        @Override
        public String toString() {
            return "SmallPair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}