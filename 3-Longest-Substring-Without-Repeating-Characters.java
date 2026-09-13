class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        Map<Character, Integer> lastIndexAt = new HashMap<>();

        int start = 0;
        int maxLength = 0;
        for(int end = 0 ; end < n ; end++){
            char c = s.charAt(end);
            Integer indexAt = lastIndexAt.getOrDefault(c, -1);
            if(indexAt >= start){
                start = indexAt + 1;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            lastIndexAt.put(c, end);
        }
        return maxLength;
    }
}