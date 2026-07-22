class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        Map<Character, Integer> lastIndexAt = new HashMap<>();
        int start = 0, windowEnd = 0;
        int longestSubstringLength = 0;

        for(int end = 0 ; end < n ; end++){
            char c = s.charAt(end);
            int lastIndexOfC = lastIndexAt.getOrDefault(c, -1);

            if(lastIndexOfC == -1 || lastIndexOfC < start){
                lastIndexAt.put(c, end);
                longestSubstringLength = Math.max(longestSubstringLength, end - start + 1);
                continue;
            }
            
            start = lastIndexOfC + 1;
            longestSubstringLength = Math.max(longestSubstringLength, end - start + 1);
            lastIndexAt.put(c, end);
        
        }
        return longestSubstringLength;
    }
}