1class Solution {
2    public int longestStrChain(String[] words) {
3
4        int n = words.length;
5        Arrays.sort(words, 
6            (a, b) -> Integer.compare(a.length(), b.length())
7        );
8
9        Map<String, Integer> lscAtIndex = new HashMap<>();
10
11        for(int index = 0 ; index < n ; index ++){
12
13            String word = words[index];
14            int length = word.length();
15            int curentMax = 1;
16            for(int i = 0 ; i < length ; i++){
17
18                String s = word.substring(0, i) + word.substring(i+1) ;
19                if(lscAtIndex.containsKey(s)){
20                    curentMax = Math.max(curentMax, lscAtIndex.get(s) + 1); 
21                }
22            }
23            lscAtIndex.put(word, curentMax);
24        }
25
26        int maxLengLcs = 1;
27        for(int len : lscAtIndex.values()){
28            maxLengLcs = Math.max(maxLengLcs, len);
29        }
30        
31        return maxLengLcs;
32    }
33}