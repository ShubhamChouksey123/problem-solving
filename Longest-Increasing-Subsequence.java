1class Solution {
2
3    private int lengthOfLISUtil(int[] nums, int[] lcs, int index){
4
5        if(index == 0)
6            return 1;
7
8        if(lcs[index] != -1)
9            return lcs[index];
10
11        int maxLen = 1;
12        for(int i = 0 ; i < index ; i++){
13            if(nums[i] < nums[index]){
14                maxLen =  Math.max(maxLen, 1 + lengthOfLISUtil(nums, lcs, i)) ;
15            }
16        }
17        lcs[index] = maxLen;
18        return maxLen;
19    }
20
21    public int lengthOfLIS(int[] nums) {
22        
23        int n = nums.length;
24        int[] lcs = new int[n];
25        Arrays.fill(lcs, -1);
26        lcs[0] = 1;
27
28        for(int i = 1 ; i < n ; i++){
29            lengthOfLISUtil(nums, lcs, i);
30        }   
31        
32        int maxLcs = 1;
33        for(int l : lcs){
34            maxLcs = Math.max(l, maxLcs);
35        }
36        return maxLcs;
37    }
38}