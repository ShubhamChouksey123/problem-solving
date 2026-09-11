class Solution {

    public int numOfMinutesUtil(int[] manager, int[] informTime, int[] totalTime, int empId) {

        if(manager[empId] == -1) return 0;

        if(totalTime[empId] != Integer.MAX_VALUE) return totalTime[empId];

        int managerId = manager[empId];
        totalTime[empId] = informTime[managerId] + numOfMinutesUtil(manager, informTime, totalTime, managerId);

        return totalTime[empId];
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        int[] totalTime = new int[n];
        Arrays.fill(totalTime, Integer.MAX_VALUE);
        totalTime[headID] = 0;

        for(int i = 0 ; i < n ; i++){
            if(totalTime[i] == Integer.MAX_VALUE){
                numOfMinutesUtil(manager, informTime, totalTime, i); 
            }
        }

        int maxTime = 0;
        for(int i = 0 ; i < n ; i++){
            maxTime = Math.max(maxTime, totalTime[i]);
        }
        return maxTime;
        
    }
}