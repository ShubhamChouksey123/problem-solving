1class Solution {
2    public int searchutil(int[] nums, int target, int start, int end) {
3        if(start > end){
4            return -1;
5        }
6
7        int mid = (start + end)/2;
8        if(nums[mid] == target){
9            return mid;
10        }
11
12        if(nums[start] <= nums[mid]){
13            // In the second half, pivot lies
14            if(nums[start] <= target && target <= nums[mid]){
15                return searchutil(nums, target, start, mid - 1);
16            }else{
17                return searchutil(nums, target, mid + 1, end); 
18            }
19        }else{
20            // In the first half, Pivot lies
21            if(nums[mid] <= target && target <= nums[end]){
22                return searchutil(nums, target, mid + 1, end);
23            }else{
24                return searchutil(nums, target, start, mid - 1); 
25            }
26        }
27    }
28    
29    public int search(int[] nums, int target) {
30        return searchutil(nums, target, 0, nums.length - 1); 
31    }
32}