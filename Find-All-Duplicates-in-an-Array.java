1class Solution {
2
3    private void swap(int[] nums, int indexA, int indexB){
4        int tmp = nums[indexA];
5        nums[indexA] = nums[indexB];
6        nums[indexB] = tmp;
7    }
8
9    private void swapStartFromIndex(int[] nums, int n, int i){
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
20    public List<Integer> findDuplicates(int[] nums) {
21
22        int n = nums.length;
23        for(int i = 0 ; i < n ; i++){
24            nums[i]--;
25        }
26
27        for(int i = 0 ; i < n ; i++){
28            swapStartFromIndex(nums, n, i);
29        }
30
31        List<Integer> result = new ArrayList<>();
32        for(int i = 0 ; i < n ; i++){
33            if(nums[i] != i){
34                result.add(nums[i] + 1);
35            }
36        }
37        return result;        
38    }
39}