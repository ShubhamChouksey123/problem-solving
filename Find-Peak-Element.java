1class Solution {
2    
3    public int findPeakElement(int[] nums, int start, int end) {
4        if(start == end){
5            return start;
6        }
7
8        int mid = start + (end - start) / 2;
9
10        if(nums[mid] < nums[mid + 1]){
11            return findPeakElement(nums, mid + 1, end); 
12        }else{
13            return findPeakElement(nums, start, mid);
14        }
15    }
16    
17    public int findPeakElement(int[] nums) {
18        return findPeakElement(nums, 0, nums.length - 1);
19    }
20}