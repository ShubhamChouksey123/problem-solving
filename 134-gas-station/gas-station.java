class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] tankUsed = new int[2 * n];

        for (int i = 0; i < n; i++) {
            tankUsed[i] = gas[i] - cost[i];
        }
        for (int i = n; i < 2 * n; i++) {
            tankUsed[i] = tankUsed[i % n];
        }

        int i = 0;
        int start = 0;
        int tank = 0;
        int length = 0;

        while (i < 2 * n) {
            tank = tank + tankUsed[i];
            if (tank >= 0) {
                i++;
                length++;
                if (length == n) {
                    // System.out.println("start : " + start);
                    return start;
                }
            } else {
                tank = 0;
                start = i + 1;
                i++;
                length = 0;
            }
        }


        // System.out.println("start not found");
        return -1;
    }
}