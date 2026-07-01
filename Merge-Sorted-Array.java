1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3
4        int index1 = m - 1;
5        int index2 = n - 1;
6
7        int index = n + m - 1;
8        while(index >= 0){
9            if(index1 >= 0 && index2 >= 0){
10                if(nums1[index1] > nums2[index2]){
11                    nums1[index] = nums1[index1--];
12                }
13                else{
14                    nums1[index] = nums2[index2--];
15                }
16            }
17            else if(index1 >= 0){
18                nums1[index] = nums1[index1--];
19            }
20            else{
21                nums1[index] = nums2[index2--];
22            }
23            index--;
24        }   
25    }
26}