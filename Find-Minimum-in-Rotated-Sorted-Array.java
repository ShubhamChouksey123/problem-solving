1class Solution {
2    public int findMin(int[] nums, int start, int end) {
3        
4        if(start > end) return 0;
5        if(start == end) return nums[start];
6        if(start + 1 == end) return Math.min(nums[start], nums[end]);
7
8        int mid = start + (end - start)/2;
9        
10        if(nums[start] <= nums[mid]){
11            // first half is increasing
12            if(nums[mid] > nums[end]){
13                return findMin(nums, mid + 1, end);
14            }
15            return findMin(nums, start, mid);
16        }
17        else{
18            // second half is increasing
19            if(nums[start] > nums[mid]){
20                return findMin(nums, start + 1, mid);
21            }
22            return findMin(nums, mid, end);
23        }
24
25    }
26
27    public int findMin(int[] nums) {
28        
29        int n = nums.length;
30        return findMin(nums, 0, n - 1);
31
32    }
33}