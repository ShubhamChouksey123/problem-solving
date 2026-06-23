1class Solution {
2    
3    public int maxSumAfterPartitioning(int[] arr, int n, int k, int[] memoCache, int start) {
4        
5        if(start >= n) return 0;
6
7        if(memoCache[start] != -1){
8            return memoCache[start];
9        }
10
11        int maxValue = 0;
12        int partitionMaxValue = 0;
13        for(int len = 1 ; len <= k && start + len - 1 < n ; len++){
14            int index = start + len - 1;
15            partitionMaxValue = Math.max(partitionMaxValue, arr[index]);
16            int partitionSum = (partitionMaxValue * len) + maxSumAfterPartitioning(arr, n, k, memoCache, index + 1);
17            maxValue = Math.max(maxValue, partitionSum);
18        }
19
20        memoCache[start] = maxValue;
21        return maxValue;
22    }
23    
24    public int maxSumAfterPartitioning(int[] arr, int k) {
25        
26        int n = arr.length;
27        int[] memoCache = new int[n];
28        Arrays.fill(memoCache, -1);
29        return maxSumAfterPartitioning(arr, n, k, memoCache, 0);
30    }
31}