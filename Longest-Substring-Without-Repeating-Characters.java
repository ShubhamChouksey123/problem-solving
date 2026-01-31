1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3
4        Map<Character, Integer> mp = new HashMap<>();
5        int start = 0, len = 0, maxLen = 0;
6
7        for(int end = 0 ; end < s.length() ; end++){
8            Character c = s.charAt(end);
9            if(mp.containsKey(c)){
10                int index = mp.get(c);
11                while(start <= index){
12                    mp.remove(s.charAt(index));
13                    start++;
14                }
15            }
16            mp.put(c, end);
17            maxLen = Math.max(maxLen, end - start + 1);
18        }
19        return maxLen;
20    }
21}