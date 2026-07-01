1class Solution {
2    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
3
4        Queue<int[]> pq = new PriorityQueue<>(
5            (a, b) -> {
6                return Integer.compare(a[2], b[2]);
7            }
8        );
9        
10        int n = nums1.length, m = nums2.length;
11        for(int i = 0 ; i < n && i < k; i++){
12            pq.add(new int[]{i, 0, nums1[i] + nums2[0]});
13        }
14
15        List<List<Integer>> result = new ArrayList<>();
16
17        int addedInResult = 0;
18        while(addedInResult < k && !pq.isEmpty()){
19            int[] topElement = pq.poll();
20            int indexInNum1 = topElement[0], indexInNum2 = topElement[1];
21            result.add(List.of(nums1[indexInNum1], nums2[indexInNum2]));
22            addedInResult++;
23            if(indexInNum2 + 1 < m){
24                pq.add(new int[]{indexInNum1, indexInNum2 + 1, nums1[indexInNum1] + nums2[indexInNum2 + 1]});
25            }
26        }
27
28        return result;
29    }
30}