1class Solution {
2    
3    public int minCost(int[] cuts, int[][] memoCache, int start, int end) {
4        
5        if(start > end) return 0;
6        if(memoCache[start][end] != -1){
7            return memoCache[start][end];
8        }
9
10        int minCost = Integer.MAX_VALUE;
11        for(int i = start ; i <= end ; i++){
12            int currentCutCost = cuts[end + 1] - cuts[start - 1];
13            int leftSubSetCost = minCost(cuts, memoCache, start, i - 1); 
14            int rightSubSetCost = minCost(cuts, memoCache, i + 1, end);
15
16            minCost = Math.min(minCost, currentCutCost + leftSubSetCost + rightSubSetCost);
17        }
18
19        memoCache[start][end] = minCost;
20        return minCost;
21    }
22    
23    public int minCost(int n, int[] cuts) {
24        
25        Arrays.sort(cuts);
26        int length = cuts.length;
27        int newLength = length + 2;
28        int[] newCuts = new int[newLength];
29        newCuts[0] = 0; newCuts[newLength - 1] = n;
30        for(int i = 0 ; i < length ; i++){
31            newCuts[i+1] = cuts[i];
32        }
33
34        int[][] memoCache = new int[newLength][newLength];
35        for(int[] row : memoCache){
36            Arrays.fill(row, -1);
37        }
38
39        return minCost(newCuts, memoCache, 1, newLength - 2);
40    }
41}