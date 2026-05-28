1class Solution {
2
3    public int findNumberOfLISUtil(int[] nums, int[] memo, int[] length, int index) {
4
5        if(index == 0)
6            return 1;
7
8        if(memo[index] != -1)
9            return memo[index];
10        
11        int currentIndexLength = 1;
12
13        for(int i = 0 ; i < index ; i++){
14            int previousMax = findNumberOfLISUtil(nums, memo, length, i);
15            
16            if(nums[i] < nums[index] ){
17                if(currentIndexLength < 1 + previousMax){
18                    currentIndexLength = 1 + previousMax;
19                    length[index] = length[i];
20
21                }
22                else if(currentIndexLength == 1 + previousMax){
23                    length[index] += length[i];
24                }
25            }
26        }
27
28
29        memo[index] = currentIndexLength;
30        return currentIndexLength;
31    }
32
33    public int findNumberOfLIS(int[] nums) {
34
35        int n = nums.length;
36        int[] memo = new int[n];
37        int[] length = new int[n];
38        Arrays.fill(memo, -1);
39        Arrays.fill(length, 1);
40        memo[0] = 1;
41        length[0] = 1;    
42
43        findNumberOfLISUtil(nums, memo, length, n - 1);
44
45        int maxLength = 1; int maxLengthCount = 1;
46
47        for(int index = 1 ; index < n ; index++){
48            if(memo[index] > maxLength){
49                maxLength = memo[index];
50                maxLengthCount = length[index];
51            }
52            else if(memo[index] == maxLength){
53                maxLengthCount += length[index];
54            }
55        }
56
57
58        return maxLengthCount;
59    }
60}