class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        Queue<Integer> numbers = new PriorityQueue<>();
        for (int num : hand) {
            numbers.add(num);
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : hand) {
            Integer currentCount = counts.get(num);
            if (currentCount == null) {
                counts.put(num, 1);
            } else {
                counts.put(num, currentCount + 1);
            }
        }

        while (!numbers.isEmpty()) {
            int number = numbers.poll();
            int count = counts.get(number);

            if (count == 0) {
                continue;
            }

            counts.put(number, 0);

            int k = groupSize - 1;
            int nextNumber = number + 1;
            while (k-- > 0) {
                Integer nextNumberCount = counts.get(nextNumber);
                if (nextNumberCount == null || nextNumberCount < count) {
                    return false;
                }
                counts.put(nextNumber, nextNumberCount - count);
                nextNumber++;
            }


        }

        return true;
    }
}