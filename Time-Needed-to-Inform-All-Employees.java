1class Solution {
2
3    private int getTime(int n, int headID, int[] manager, int[] informTime, int empIndex, int[] totalInformTime){
4        if(manager[empIndex] == -1){
5            totalInformTime[empIndex] = 0;
6            return totalInformTime[empIndex];
7        }
8
9        int managerIndex = manager[empIndex];
10        totalInformTime[empIndex] = informTime[managerIndex] + getTime(n, headID, manager, informTime, managerIndex, totalInformTime);
11        return totalInformTime[empIndex];
12    }
13
14    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
15
16        int[] totalInformTime = new int[n];
17        Arrays.fill(totalInformTime, -1);
18
19        for(int i = 0 ; i < n ; i++){
20            if(totalInformTime[i] == -1){
21                getTime(n, headID, manager, informTime, i, totalInformTime);
22            }
23        }
24
25        int max = 0;
26        for(int i = 0 ; i < n ; i++){
27            max = Math.max(max, totalInformTime[i]);
28        }
29        return max;
30    }
31}