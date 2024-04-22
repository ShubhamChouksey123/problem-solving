class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        Set<Character> st = new HashSet<>();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (st.contains(c)) {
                while (s.charAt(start) != c) {
                    st.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                st.add(c);
            }

            maxLength = Math.max(maxLength, i - start + 1);

        }

        return maxLength;
        
    }
}