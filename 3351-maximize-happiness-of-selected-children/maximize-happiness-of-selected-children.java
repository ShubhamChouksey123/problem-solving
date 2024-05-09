class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {

        int n = happiness.length;
        PriorityQueue<Long> pq = new PriorityQueue<>();


        for (int i = 0; i < n; i++) {
            if (pq.size() < k) {
                pq.add((long) happiness[i]);
                continue;
            }

            Long top = pq.peek();
            Long element = Long.valueOf(happiness[i]);
            if (top < element) {
                pq.poll();
                pq.add( element);
            }
        }

        Long[] kTopElements = new Long[pq.size()];
//        List<Integer> kTopElements = new ArrayList<>(pq.size());
        int index = k - 1;
        while (!pq.isEmpty()) {
            Long element = pq.poll();
            kTopElements[index] = element;
            index--;
        }

        Long sum = 0L;
        for (int i = 0; i < k; i++) {
            if(kTopElements[i] - i > 0){
                sum += kTopElements[i] - i;
            }
        }

        return sum;
    }
}