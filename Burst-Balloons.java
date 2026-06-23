1class Solution {
2    
3    public int maxCoins(int[] nums, int n, int[][] memoCache, int start, int end) {
4        
5        if(start > end) return 0;
6        if(start == end) return nums[start -1] * nums[start] * nums[start + 1];
7
8        if(memoCache[start][end] != -1){
9            return memoCache[start][end];
10        }
11
12        int maxCoins = 0;
13        for(int index = start; index <= end ; index++){
14            int burstCoins = nums[start-1] * nums[index] * nums[end+1];
15            int leftSubsetCoins = maxCoins(nums, n, memoCache, start, index - 1);
16            int rightSubsetCoins = maxCoins(nums, n, memoCache, index + 1, end);
17
18            int thisSetSum = burstCoins + leftSubsetCoins + rightSubsetCoins;
19            maxCoins = Math.max(maxCoins, thisSetSum);
20        }
21
22        memoCache[start][end] = maxCoins;
23        return maxCoins;
24    }
25    
26    public int maxCoins(int[] nums) {
27        
28        int length = nums.length;
29        int n = length + 2;
30        int[] newNums = new int[n];
31        
32        newNums[0] = 1; newNums[n-1] = 1;
33        for(int i = 0 ; i < length ; i++){
34            newNums[i+1] = nums[i];
35        }
36
37        int[][] memoCache = new int[n][n];
38        for(int[] row : memoCache){
39            Arrays.fill(row, -1);
40        }
41        return maxCoins(newNums, n, memoCache, 1, n - 2); 
42    }
43}