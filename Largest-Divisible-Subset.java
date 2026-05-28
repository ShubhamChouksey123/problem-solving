1class Solution {
2
3    private int largestDivisibleSubsetUntil(int[] nums, int[] memo, int[] prev, int index){
4
5        if(index == 0)
6            return 1;
7
8        if(memo[index] != -1)
9            return memo[index];
10
11        int maxSize = 1; 
12        for(int i = 0 ; i < index ; i++){
13            int premaxSize = largestDivisibleSubsetUntil(nums, memo, prev, i);
14
15            if(nums[index] % nums[i] == 0){
16                if(1 + premaxSize > maxSize){
17                    maxSize = 1 + premaxSize;
18                    prev[index] = i;
19                }
20                
21            }
22        }
23
24        memo[index] = maxSize;
25        return maxSize;
26    }
27
28    public List<Integer> largestDivisibleSubset(int[] nums) {
29
30        int n = nums.length;
31        Arrays.sort(nums);
32
33        int[] memo = new int[n];
34        int[] prev = new int[n];
35        Arrays.fill(memo, -1);
36        Arrays.fill(prev, -1);
37        memo[0] = 1;
38        prev[0] = -1;
39        
40        largestDivisibleSubsetUntil(nums, memo, prev, n - 1);
41
42        int maxSize = 1;
43        int maxSizeLastElement = 0;
44        for(int index = 0; index < n ; index++){
45            if(memo[index] > maxSize){
46                maxSize = memo[index];
47                maxSizeLastElement = index; 
48            }
49        }
50
51        List<Integer> ans = new ArrayList<>();
52        while(maxSizeLastElement != -1){
53            ans.add(nums[maxSizeLastElement]);
54            maxSizeLastElement = prev[maxSizeLastElement];
55        }
56
57        return ans;
58    }
59}
60
61