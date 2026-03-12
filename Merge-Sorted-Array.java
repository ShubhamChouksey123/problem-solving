1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3        
4        int i = m - 1, j = n - 1;
5        System.out.println("i : " + i + ", and j : " + j);
6        
7        while(i >= 0 || j >= 0){
8            if(i >= 0 && j >= 0){
9                if(nums1[i] > nums2[j]){
10                    nums1[i + j + 1] = nums1[i]; i--;
11                }
12                else{
13                    nums1[i + j + 1] = nums2[j]; j--;
14                }
15                
16            }
17            else if(i >= 0){
18                nums1[i + j + 1] = nums1[i]; i--; 
19            }
20            else if(j >= 0){
21                nums1[i + j + 1] = nums2[j]; j--; 
22            }else{
23                break;
24            }
25        }
26
27    }
28}