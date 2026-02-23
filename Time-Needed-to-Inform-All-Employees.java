1class Solution {
2
3    private int getTime(int n, int headID, int[] manager, int[] informTime, int empIndex, int[] totalInformTime){
4        if(manager[empIndex] == -1){
5            totalInformTime[empIndex] = 0;
6            return totalInformTime[empIndex];
7        }
8
9        if(totalInformTime[empIndex] != -1){
10            return totalInformTime[empIndex];
11        }
12
13        int managerIndex = manager[empIndex];
14        totalInformTime[empIndex] = informTime[managerIndex] + getTime(n, headID, manager, informTime, managerIndex, totalInformTime);
15        return totalInformTime[empIndex];
16    }
17
18    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
19
20        int[] totalInformTime = new int[n];
21        Arrays.fill(totalInformTime, -1);
22
23        for(int i = 0 ; i < n ; i++){
24            if(totalInformTime[i] == -1){
25                getTime(n, headID, manager, informTime, i, totalInformTime);
26            }
27        }
28
29        int max = 0;
30        for(int i = 0 ; i < n ; i++){
31            max = Math.max(max, totalInformTime[i]);
32        }
33        return max;
34    }
35}