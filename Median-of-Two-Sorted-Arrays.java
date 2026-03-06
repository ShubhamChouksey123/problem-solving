1class Solution {
2    
3    public double findMedianSortedArraysUtil(int[] nums1, int[] nums2, int n, int m, int start, int end) {
4        
5        int mid = start + (end - start)/2;
6
7        int l1 = mid, l2 = (n + m + 1)/2 - l1;
8        
9        int maxLeft1 = (l1 == 0) ? Integer.MIN_VALUE : nums1[l1 - 1];
10        int maxLeft2 = (l2 == 0) ? Integer.MIN_VALUE : nums2[l2 - 1]; 
11        
12        int minRight1 = (l1 == n) ? Integer.MAX_VALUE : nums1[l1]; 
13        int minRight2 = (l2 == m) ? Integer.MAX_VALUE : nums2[l2];
14
15        if(maxLeft1 <= minRight2  &&  maxLeft2 <= minRight1){
16            // correct partition
17            if((n+m) %2 == 0){
18                // even elements => average of the two mid values
19                return ((double)Math.max(maxLeft1, maxLeft2) + (double)Math.min(minRight1, minRight2) ) / (double)2 ;  
20            }
21            else{
22                // odd elements => middle value
23                return (double)Math.max(maxLeft1, maxLeft2);
24            }
25        } 
26
27        if(maxLeft1 > minRight2){
28            return findMedianSortedArraysUtil(nums1, nums2, n, m, start, l1 - 1);
29        }
30        return findMedianSortedArraysUtil(nums1, nums2, n, m, l1 + 1, end);
31    }
32    
33    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
34        int n = nums1.length;
35        int m = nums2.length;
36
37        if(n > m){
38            return findMedianSortedArrays(nums2, nums1);
39        }
40
41        return findMedianSortedArraysUtil(nums1, nums2, n, m, 0, n);
42    }
43}