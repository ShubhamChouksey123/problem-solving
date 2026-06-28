1class Solution {
2    
3    /**
4        start and end are the length of first segment in nums1
5     */
6    public double findMedianSortedArrays(int[] nums1, int[] nums2, int n, int m, int start, int end) {
7
8        
9        int mid = start + (end - start)/2;
10
11        int l1 = mid; int l2 = 0;
12        if((n + m) % 2 == 0){
13            l2 = ((n+m)/2) - l1;
14        }else{
15            l2 = ((n+m)/2 + 1) - l1;
16        }
17        
18        int a = (l1 == 0) ? Integer.MIN_VALUE : nums1[l1 - 1];
19        int x = (l2 == 0) ? Integer.MIN_VALUE : nums2[l2 - 1];
20
21
22        int b = (l1 == n) ? Integer.MAX_VALUE : nums1[l1];
23        int y = (l2 == m) ? Integer.MAX_VALUE : nums2[l2];
24
25
26        if(a <= y && x <= b){
27            // found the correct partition
28            if((n + m) % 2 == 0){
29                return ((double)Math.max(a, x) + Math.min(b, y)) / (double)2;
30            }else{
31                return (double)Math.max(a, x);
32            }
33        }
34        else if(a > y){
35            return findMedianSortedArrays(nums1, nums2, n, m, start, mid - 1);
36        }
37        return findMedianSortedArrays(nums1, nums2, n, m, mid + 1, end);
38    }
39    
40    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
41        
42        int n = nums1.length;
43        int m = nums2.length;
44
45        if(n > m) return findMedianSortedArrays(nums2, nums1); 
46
47        return findMedianSortedArrays(nums1, nums2, n, m, 0, n); 
48    }
49}