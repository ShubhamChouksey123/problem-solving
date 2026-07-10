class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums2.length;
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            valueToIndex.put(nums2[i], i);
        }

        int[] nextGreater = new int[n];
        Arrays.fill(nextGreater, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && nums2[stack.peekLast()] < nums2[i]){
                nextGreater[stack.pollLast()] = nums2[i];
            }   
            stack.offerLast(i);
        }

        int m = nums1.length;
        int[] ans = new int[m];
        for(int i = 0 ; i < m ; i++){
            ans[i] = nextGreater[valueToIndex.get(nums1[i])];
        }
        return ans;
    }
}