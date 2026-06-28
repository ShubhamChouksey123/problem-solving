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
11    private int findPeakIndex(MountainArray mountainArr, int start, int end){
12
13        if(start > end) return -1;
14        if(start == end) return start;
15        if(start + 1 == end) {
16            return (mountainArr.get(start) < mountainArr.get(start + 1)) ? start + 1 : start;
17        }
18        
19        int mid = start + (end - start)/2;
20        if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
21            return findPeakIndex(mountainArr, mid + 1, end);
22        }
23        return findPeakIndex(mountainArr, start, mid);
24
25    }
26
27    private int binarySearch(int target, MountainArray mountainArr, int start, int end, boolean increasing){
28
29        if(start > end) return -1;
30        
31        int mid = start + (end - start)/2;
32
33        if(mountainArr.get(mid) == target){
34            return mid;
35        }
36        else if(mountainArr.get(mid) < target){
37            return (increasing) ? binarySearch(target, mountainArr, mid + 1, end, increasing) : binarySearch(target, mountainArr, start, mid - 1, increasing);
38        }
39
40        return (increasing) ? binarySearch(target, mountainArr, start, mid - 1, increasing) : binarySearch(target, mountainArr, mid + 1, end, increasing);               
41    }
42    
43    public int findInMountainArray(int target, MountainArray mountainArr) {
44        int n = mountainArr.length();
45        int peakIndex = findPeakIndex(mountainArr, 0, n - 1 );
46        
47        int a = binarySearch(target, mountainArr, 0, peakIndex, true);
48        if(a != -1) return a;
49
50        int b = binarySearch(target, mountainArr, peakIndex + 1, n - 1, false) ;
51        
52        return b;
53    }
54}