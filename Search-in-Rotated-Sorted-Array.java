1class Solution {
2    
3    public int search(int[] nums, int target, int start, int end) {
4        
5        if(start > end) return -1;
6
7        int mid = start + (end - start)/2;
8        if(nums[mid] == target) return mid;
9
10        if(nums[start] <= nums[mid]){
11            // first half is striclty increasing
12            if(nums[start] <= target && target < nums[mid]){
13                return search(nums, target, start, mid - 1);
14            }
15            return search(nums, target, mid + 1, end);
16        }
17        else{
18            // seccond half is increasing
19            if(nums[mid] < target && target <= nums[end]){
20                return search(nums, target, mid + 1, end);
21            }
22            return search(nums, target, start, mid - 1);
23        }
24    }
25    
26    public int search(int[] nums, int target) {
27
28        int n = nums.length;
29        return search(nums, target, 0, n - 1);    
30    }
31}