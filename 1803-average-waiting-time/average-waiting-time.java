class Solution {
    public double averageWaitingTime(int[][] customers) {

        Arrays.sort(customers, 
            (int[] a, int[] b) -> {
                    return a[0] - b[0];
                }
        );


        int startTime = 0; long totalWaitingTime = 0;

        for(int[] customer : customers){
            startTime = Math.max(startTime, customer[0]); 
            totalWaitingTime += (startTime + customer[1] - customer[0]);
            startTime = startTime + customer[1];
        }

        return ((double)totalWaitingTime)/customers.length;
    }
}