1class Solution {
2
3    private void swap(int[] nums, int start, int end){
4        int tmp = nums[start];
5        nums[start] = nums[end];
6        nums[end] = tmp;
7    }
8
9    public void sortColors(int[] nums) {
10
11        int start = 0, n = nums.length;
12        int end = n - 1;
13
14        while(start < end){
15            if(nums[end] == 2){
16                end--;
17                continue;
18            }
19            if(nums[start] == 0 || nums[start] == 1){
20                start++;
21                continue;
22            }
23            if(nums[start] == 2){
24                swap(nums, start, end);
25                start++;
26                end--;
27            }
28        }
29
30        start = 0; end = n - 1;        
31        while(end >= 0 && nums[end] == 2){
32            end--;
33        }
34
35        start = 0;      
36        while(start < end){
37            if(nums[end] == 1){
38                end--;
39                continue;
40            }
41            if(nums[start] == 0){
42                start++;
43                continue;
44            }
45            if(nums[start] == 1 || nums[end] == 0){
46                swap(nums, start, end);
47                start++;
48                end--;
49            }
50        }
51    }
52}