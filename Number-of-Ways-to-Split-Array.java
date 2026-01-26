1class Solution {
2    public int waysToSplitArray(int[] nums) {
3
4        long totalSum = 0; int n = nums.length, count = 0;
5        for(int num : nums){
6            totalSum += num;
7        }
8
9        long leftSum = 0, rightSum = totalSum; 
10        for(int i = 0 ; i < n - 1 ; i++){
11            leftSum += nums[i];
12            rightSum -= nums[i];
13            if(leftSum >= rightSum){
14                count++;
15            }
16        }
17        return count;
18
19        
20    }
21}