1class Solution {
2
3    private int getTotalInformTime(int n, int[] manager, int[] informTime, int[] totalInformTime, int empIndex){
4
5        if(totalInformTime[empIndex] != -1){
6            return totalInformTime[empIndex];
7        }
8
9        if(manager[empIndex] == -1){
10            return 0;
11        }
12
13        int managerIndex = manager[empIndex];
14        int time = informTime[managerIndex] + getTotalInformTime(n, manager, informTime, totalInformTime, managerIndex);
15        totalInformTime[empIndex] = time;
16        return time;
17    }
18
19    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
20
21        int[] totalInformTime = new int[n];
22        Arrays.fill(totalInformTime, -1);
23
24        for(int i = 0 ; i < n ; i++){
25            totalInformTime[i] =  getTotalInformTime(n, manager, informTime, totalInformTime, i);
26        }
27
28        int maxtime = Integer.MIN_VALUE;
29        for(int i = 0 ; i < n ; i++){
30            maxtime = Math.max(totalInformTime[i] , maxtime);
31        }
32        return maxtime;
33
34    }
35}