class Solution {
    public int longestConsecutive(int[] nums) {
         Set<Integer> st = new HashSet<>();

        for (int i : nums) {
            st.add(i);
        }

        int n = nums.length;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (st.contains(num - 1)) {
                continue;
            }

            int length = 1;
            while (st.contains(num + 1)) {
                num = num + 1;
                length++;
            }
            maxLength = Math.max(length, maxLength);
        }

        return maxLength;   
    }
}