1class Solution {
2
3    private boolean liesInRange(int n, int index){
4        return (index >= 0 && index < n);
5    }
6    
7    private double findMedianSortedArrays(int[] nums1, int[] nums2, int n, int m, int start , int end) {
8
9        int mid = start + (end - start) / 2;
10        int l1 = mid, l2 = (n + m + 1)/2 - l1;
11        
12        int maxLeft1 = (l1 == 0) ? Integer.MIN_VALUE : nums1[l1-1];
13        int maxLeft2 = (l2 == 0) ? Integer.MIN_VALUE : nums2[l2-1];
14
15        int minRight1 = (l1 == n) ? Integer.MAX_VALUE : nums1[l1];
16        int minRight2 = (l2 == m) ? Integer.MAX_VALUE : nums2[l2];  
17
18        if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
19            if((n + m) % 2 == 1){
20                // total odd elements => single middle element
21                return Math.max(maxLeft1, maxLeft2);
22            }
23            else{
24                return ((double)(Math.max(maxLeft1, maxLeft2)) + ((double)Math.min(minRight1, minRight2))) / 2; 
25            }
26        }  
27        else if(maxLeft1 > minRight2){
28            return findMedianSortedArrays(nums1, nums2, n, m, start, l1 - 1); 
29        }
30        return findMedianSortedArrays(nums1, nums2, n, m, l1 + 1, end);         
31    }
32    
33    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
34
35        int n = nums1.length, m = nums2.length;
36        if(n > m){
37            return findMedianSortedArrays(nums2, nums1); 
38        }
39        
40        return findMedianSortedArrays(nums1, nums2, n, m, 0 , n);
41    }
42}