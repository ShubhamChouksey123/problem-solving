class Solution {
    public int numRescueBoats(int[] people, int limit) {

        int n = people.length;

        Arrays.sort(people);

        boolean[] isCounted = new boolean[n];


        int totalBoats = 0;
        int start = n - 2;
        for (int i = n - 1; i >= 0; i--) {
            if (isCounted[i]) {
                continue;
            }
            if (people[i] == limit) {
                totalBoats++;
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (people[i] + people[j] <= limit && !isCounted[j]) {
                    isCounted[j] = true;
                    break;
                }
            }
            totalBoats++;
        }
        return totalBoats;
    }
}