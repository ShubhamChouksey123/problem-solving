1class Solution {
2    
3    public boolean search(int[] nums, int target, int start, int end) {
4
5        if(start > end){
6            return false;
7        }
8
9        int mid = (start + end) / 2;
10        if(nums[mid] == target) {
11            return true;
12        }
13        if(nums[start] == nums[mid] && nums[mid] == nums[end]){
14            return search(nums, target, start + 1, end - 1);
15        }
16
17        if(nums[start] <= nums[mid]){
18            // first half is purely increasing, second half has pivot
19            if(nums[start] <= target && target <= nums[mid]){
20                return search(nums, target, start, mid - 1); 
21            }else{
22                return search(nums, target, mid + 1, end); 
23            }
24        }else{
25            // second half is purely increasing, first half has pivot
26            if(nums[mid] <= target && target <= nums[end]){
27                return search(nums, target, mid + 1, end); 
28            }else{
29                return search(nums, target, start, mid - 1); 
30            }
31        }
32    }
33    
34    public boolean search(int[] nums, int target) {
35        return search(nums, target, 0, nums.length - 1);
36    }
37}