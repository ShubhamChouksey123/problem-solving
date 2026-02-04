1class Solution {
2
3    private void swap(int[] nums, int indexA, int indexB){
4        int tmp = nums[indexA];
5        nums[indexA] = nums[indexB];
6        nums[indexB] = tmp;
7    }
8
9    private void swapFromStartIndex(int[] nums, int i){
10
11        while(nums[i] > 0 && nums[i] - 1 != i){
12            int correctIndex = nums[i] - 1;
13            if(correctIndex >= 0 && nums[i] == nums[correctIndex]){
14                break;
15            }
16            swap(nums, i, correctIndex);
17        }
18    }
19
20
21
22    public int firstMissingPositive(int[] nums) {
23
24        int n = nums.length;
25        for(int i = 0 ; i < n ; i++){
26            if(nums[i] > n){
27                nums[i] = 0;
28            }
29        }
30
31        for(int i = 0 ; i < n ; i++){
32            swapFromStartIndex(nums, i);
33        }
34
35        for(int i = 0 ; i < n ; i++){
36            if(nums[i] - 1 != i ){
37                return i+1;
38            }
39        }
40        return n + 1;        
41    }
42}