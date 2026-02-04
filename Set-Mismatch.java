1class Solution {
2
3    private void swap(int[] nums, int indexA, int indexB){
4        int tmp = nums[indexA];
5        nums[indexA] = nums[indexB];
6        nums[indexB] = tmp;
7    }
8
9    private void swapStartFromIndex(int[] nums, int i){
10
11        while(nums[i] != i){
12            int correctIndex = nums[i];
13            if(nums[i] == nums[correctIndex]){
14                break;
15            }
16            swap(nums, i, correctIndex);
17        }
18    }
19
20    public int[] findErrorNums(int[] nums) {
21        int n = nums.length;
22
23        for(int i = 0; i < n ; i++){
24            nums[i]--;
25        }
26
27        for(int i = 0 ; i < n ; i++){
28            swapStartFromIndex(nums, i);
29        }
30
31
32        int[] result = new int[2];
33        for(int i = 0 ; i < n ; i++){
34            if(nums[i] != i){
35                result[0] = nums[i] + 1;
36                result[1] = i+1;
37            }
38        }
39        return result;
40        
41    }
42}