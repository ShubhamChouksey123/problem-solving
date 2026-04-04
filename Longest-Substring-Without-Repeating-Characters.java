1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3
4        char[] chars = s.toCharArray();
5        /**
6            Map containing character and its latest index
7         */
8        Map<Character, Integer> indexOfChar = new HashMap<>();
9        int len = 0, maxLength = 0;
10
11        for(int i = 0 ; i < chars.length ; i++){
12            char c = chars[i];
13            Integer index = indexOfChar.getOrDefault(c, -1);
14
15            if(index == -1 || index < i - len){
16                len++;
17            }
18            else{
19                len = i - index;
20            }
21            indexOfChar.put(c, i);
22            maxLength = Math.max(maxLength, len);
23        }
24        return maxLength;
25    }
26}