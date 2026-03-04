1class Solution {
2
3    private boolean liesInRange(int n, int index){
4        return (index >= 0 && index < n);
5    }
6    
7    private double findMedianSortedArrays(int[] nums1, int[] nums2, int n, int m, int start , int end) {
8
9        int mid = start + (end - start) / 2;
10        int l1 = mid, l2 = (n + m)/2 - l1;
11        int r1 = l1 + 1, r2 = l2 + 1;        
12        
13        if(l2 > m){
14            return findMedianSortedArrays(nums1, nums2, n, m, l1 + 1 , end); 
15        }
16        if(l2 < 0){
17            return findMedianSortedArrays(nums1, nums2, n, m, start, l1 - 1); 
18        }
19
20        if(liesInRange(m, l2 - 1) && liesInRange(n, r1 - 1) && nums2[l2-1] > nums1[r1-1]){
21            return findMedianSortedArrays(nums1, nums2, n, m, l1 + 1 , end); 
22        }
23        if(liesInRange(n, l1 - 1) && liesInRange(m, r2 - 1) && nums1[l1-1] > nums2[r2-1]){
24            return findMedianSortedArrays(nums1, nums2, n, m, start , l1 - 1); 
25        } 
26
27        if((n+m)%2 == 1){
28            // combined odd elements
29            int ans = Integer.MAX_VALUE;
30            if(liesInRange(n, r1 - 1)){
31                ans = Math.min(ans, nums1[r1-1]);
32            }
33            if(liesInRange(m, r2 - 1)){
34                ans = Math.min(ans, nums2[r2-1]);
35            } 
36            return ans;
37        }
38        else{
39            int m1 = Integer.MIN_VALUE;
40            if(liesInRange(n, l1 - 1)){
41                m1 = Math.max(m1, nums1[l1-1]);
42            }
43            if(liesInRange(m, l2 - 1)){
44                m1 = Math.max(m1, nums2[l2-1]);
45            }
46
47            int m2 = Integer.MAX_VALUE;
48            if(liesInRange(n, r1 - 1)){
49                m2 = Math.min(m2, nums1[r1-1]);
50            }
51            if(liesInRange(m, r2 - 1)){
52                m2 = Math.min(m2, nums2[r2-1]);
53            }
54            return ((double)m1 + (double)m2)/2;
55
56        }
57        
58    }
59    
60    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
61
62        int n = nums1.length, m = nums2.length;
63        return findMedianSortedArrays(nums1, nums2, n, m, 0 , n);
64        
65    }
66}