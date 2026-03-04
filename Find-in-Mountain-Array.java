1/**
2 * // This is MountainArray's API interface.
3 * // You should not implement it, or speculate about its implementation
4 * interface MountainArray {
5 *     public int get(int index) {}
6 *     public int length() {}
7 * }
8 */
9 
10class Solution {
11    private int findPeakIndexInArray(int target, MountainArray mountainArr, int start, int end) {
12        if(start == end){
13            return start;
14        }
15        if(start + 1 == end){
16            return (mountainArr.get(start) > mountainArr.get(end)) ? start : end;
17        }
18
19        int mid = start + (end - start)/2;
20
21        if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
22            // first half is increasing
23            return findPeakIndexInArray(target, mountainArr, mid + 1, end); 
24        }
25        return findPeakIndexInArray(target, mountainArr, start, mid); 
26    }
27
28    private int searchSorted(int target, MountainArray mountainArr, int start, int end){
29        
30        if(start > end){
31            return -1;
32        }    
33        
34        if (start == end){
35            if(mountainArr.get(start) == target){
36                return start;
37            }
38            return -1;
39        }
40
41        int mid = start + (end - start)/2;
42        if(mountainArr.get(mid) == target){
43            return mid;
44        }
45        else if(mountainArr.get(mid) < target){
46            return searchSorted(target, mountainArr, mid + 1, end);
47        }
48        else {
49            return searchSorted(target, mountainArr, start, mid - 1);
50        }  
51    }
52
53    private int searchReverseSorted(int target, MountainArray mountainArr, int start, int end){
54        if(start > end){
55            return -1;
56        }
57        if (start == end){
58            if(mountainArr.get(start) == target){
59                return start;
60            }
61            return -1;
62        }
63
64        int mid = start + (end - start)/2;
65        if(mountainArr.get(mid) == target){
66            return mid;
67        }
68        else if(mountainArr.get(mid) < target){
69            return searchReverseSorted(target, mountainArr, start, mid - 1);
70        }
71        else{
72            return searchReverseSorted(target, mountainArr, mid + 1, end);
73        }  
74    }
75
76
77    
78    public int findInMountainArray(int target, MountainArray mountainArr) {
79        int peakIndex = findPeakIndexInArray(target, mountainArr, 0, mountainArr.length() - 1); 
80        
81        int indexInFirstHalf = searchSorted(target, mountainArr, 0, peakIndex);
82        if(indexInFirstHalf != -1){
83            return indexInFirstHalf;
84        }
85        int indexInSeondHalf = searchReverseSorted(target, mountainArr, peakIndex + 1, mountainArr.length() - 1);
86
87        return indexInSeondHalf;
88    }
89}