1class Solution {
2    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
3
4        int n = nums1.length, m = nums2.length;
5        List<List<Integer>> result = new ArrayList<>();
6
7        Queue<int[]> minHeap = new PriorityQueue<>(
8            (int[] a, int[] b) -> {
9                return Integer.compare(a[0], b[0]);
10            }
11        );
12        
13        int i = 0, j = 0;
14        for(i = 0 ; i < k && i < n ; i++){
15            minHeap.add(new int[]{nums1[i] + nums2[0], i, 0});
16        }
17
18        while(k > 0 && !minHeap.isEmpty()){
19            int[] tmp = minHeap.poll();
20            i = tmp[1]; j = tmp[2];
21            result.add(List.of(nums1[i], nums2[j])); k--;
22            
23            if(j + 1 < m){
24                minHeap.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
25            }
26        }
27        
28        return result;
29    }
30}