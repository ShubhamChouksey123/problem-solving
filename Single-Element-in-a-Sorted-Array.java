1class Solution {
2    public int singleNonDuplicateUtil(int[] nums, int start, int end) {
3        
4        System.out.println("start : " + start + ", and end : " + end);
5        System.out.println("start value : " + nums[start] + ", and end value : " + nums[end]);
6        if(start == end){
7            return nums[start];
8        }
9
10        int mid = start + (end - start) / 2;
11        if(mid %2 == 1) mid--;
12
13        if(nums[mid + 1] == nums[mid + 2]){
14            return singleNonDuplicateUtil(nums, start, mid);
15        }
16        
17        return singleNonDuplicateUtil(nums, mid + 2, end);
18
19    }
20
21    public int singleNonDuplicate(int[] nums) {
22        return singleNonDuplicateUtil(nums, 0, nums.length - 1);
23    }
24}