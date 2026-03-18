1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3
4        int n = nums2.length;
5        Stack<int[]> st = new Stack<>();
6        int[] nextGreatestRight = new int[n];
7        Arrays.fill(nextGreatestRight, -1);
8
9        for(int i = 0 ; i < n ; i++){
10            while( !st.isEmpty() && nums2[i] > st.peek()[0] ) {
11                int[] topElement = st.pop();
12                nextGreatestRight[topElement[1]] = nums2[i];
13            }
14            st.push(new int[]{nums2[i], i});
15        }
16
17        Map<Integer, Integer> indexMap = new HashMap<>();  
18        for(int i = 0 ; i < nums2.length ; i++){
19            indexMap.put(nums2[i], i);
20        }
21
22        int[] ans = new int[nums1.length];
23
24        for(int i = 0 ; i < nums1.length ; i++){
25            int indexAt = indexMap.get(nums1[i]);
26            ans[i] = nextGreatestRight[indexAt];
27        }
28
29        return ans;
30    }
31}