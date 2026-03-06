1class Solution {
2
3    private void swap(int[] nums, int index1, int index2){
4        int tmp = nums[index1];
5        nums[index1] = nums[index2];
6        nums[index2] = tmp;
7    }
8    
9    private void swapStartingFromIndex(int[] nums, int n, int index) {
10
11        while(nums[index] < n && nums[index] != index){
12            swap(nums, nums[index], index);
13        }
14    }
15
16    public int missingNumber(int[] nums) {
17        int n = nums.length;
18        for(int i = 0 ; i < n ; i++){
19            swapStartingFromIndex(nums, n, i);
20        } 
21
22        for(int i = 0 ; i < n ; i++){
23            if(nums[i] != i){
24                return i;
25            }
26        } 
27        return n;
28    }
29}