1class Solution {
2    
3    public int findPeakElement(int[] nums, int start, int end) {
4        
5        if(start > end) return -1;
6        System.out.println("start : " + nums[start] + ", end : " + nums[end]);
7        if(start == end) return start;
8        if(start + 1 == end){
9            return (nums[start] < nums[end]) ? end : start;
10        }
11
12        int mid = start + (end - start)/2;
13
14        if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) return mid;
15
16        if(nums[mid] < nums[mid + 1]){
17            return findPeakElement(nums, mid + 1, end);
18        }
19
20        return findPeakElement(nums, start, mid);
21
22    }
23    
24    public int findPeakElement(int[] nums) {
25        
26        return findPeakElement(nums, 0, nums.length - 1); 
27    }
28}