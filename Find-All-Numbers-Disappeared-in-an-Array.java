1class Solution {
2
3    private void swap(int[] nums, int indexA, int indexB){
4        int tmp = nums[indexA];
5        nums[indexA] = nums[indexB];
6        nums[indexB] = tmp;
7    }
8
9    private void print(int[] nums){
10        for(int i : nums){
11            System.out.print(i + ",");
12        }
13        System.out.println("");
14    }
15
16
17    public List<Integer> findDisappearedNumbers(int[] nums) {
18
19        int n = nums.length;
20        for(int i = 0 ; i < n ; i++){
21            nums[i]--;
22        }
23
24        int i = 0;
25        while(i < n){
26            int correctIndex = nums[i];
27            if(nums[i] == nums[correctIndex]){
28                i++;
29            }else if(nums[i] != i){
30                swap(nums, i, correctIndex);
31            }else{
32                i++;
33            }
34        }
35        
36        List<Integer> result = new ArrayList<>();
37        for(i = 0 ; i < n ; i++){
38            if(nums[i] != i){
39                result.add(i+1);
40            }
41        }
42        return result;
43    }
44}