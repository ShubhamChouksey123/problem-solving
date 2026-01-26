1class Solution {
2    public int findMiddleIndex(int[] nums) {
3        int n = nums.length;
4        int[] leftSum = new int[n];
5        int[] rightSum = new int[n];
6
7        int sum = 0;
8        for(int i = 0 ; i < n ; i++){
9            leftSum[i] = sum;
10            sum += nums[i];
11        }
12
13        sum = 0;
14        for(int i = n-1 ; i >= 0 ; i--){
15            rightSum[i] = sum;
16            sum += nums[i];
17        }
18
19        for(int i = 0 ; i < n ; i++){
20            if(leftSum[i] == rightSum[i]){
21                return i;
22            }
23        }
24        return -1;
25    }
26}