1class Solution {
2
3    private void swap(int[] nums, int indexA, int indexB){
4        int tmp = nums[indexA];
5        nums[indexA] = nums[indexB];
6        nums[indexB] = tmp;
7    }
8
9    private int getPivot(int[] nums, int n){
10
11        for(int i = n-2 ; i >= 0 ; i--){
12            if(nums[i] < nums[i+1]){
13                return i;
14            }
15        }
16        return -1;
17    }
18
19    private int getRightMostGreaterElement(int[] nums, int n, int pivotIndex){
20
21        for(int i = n-1 ; i > pivotIndex ; i--){
22            if(nums[pivotIndex] < nums[i]){
23                return i;
24            }
25        }
26        return -1;
27
28    }
29
30    public void nextPermutation(int[] nums) {
31
32        int n = nums.length;
33        int pivotIndex = getPivot(nums, n);
34
35        if(pivotIndex == -1){
36            Arrays.sort(nums);
37            return;
38        }
39
40        int rightMostGreaterElementIndex = getRightMostGreaterElement(nums, n, pivotIndex);
41        swap(nums, pivotIndex, rightMostGreaterElementIndex);
42
43        Arrays.sort(nums, pivotIndex + 1, n);
44        
45    }
46}