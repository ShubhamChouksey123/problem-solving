1class Solution {
2    public String minWindow(String s, String t) {
3
4        int n = s.length(), m = t.length();
5        Map<Character, Integer> countOfCahrInT = new HashMap<>();
6        Map<Character, Integer> countOfCahrInS = new HashMap<>();
7
8        for(char c : t.toCharArray()){
9            countOfCahrInT.put(c, countOfCahrInT.getOrDefault(c, 0) + 1);
10        }
11
12        // matched charatcer count 
13        int matchedChar = 0;
14        String ans = ""; int len = Integer.MAX_VALUE, start = 0; 
15
16        for(int end = 0 ; end < n ; end++){
17            char c = s.charAt(end);
18            int currentCount = countOfCahrInS.getOrDefault(c, 0);
19            int idealCount = countOfCahrInT.getOrDefault(c, 0);
20
21            if(currentCount < idealCount){
22                matchedChar++;
23            }
24
25            countOfCahrInS.put(c, currentCount + 1);
26            
27
28            while( start <= end
29                && countOfCahrInS.getOrDefault(s.charAt(start), 0) > countOfCahrInT.getOrDefault(s.charAt(start), 0)){
30
31                c = s.charAt(start);    
32                countOfCahrInS.put(c, countOfCahrInS.get(s.charAt(start)) - 1);    
33                start++;
34                
35            }
36
37            if(matchedChar == m){
38                if((end - start + 1) < len){
39                    ans = s.substring(start, end + 1);
40                    len = (end - start + 1);
41                }
42            }
43        }
44
45        return ans;
46
47    }
48}