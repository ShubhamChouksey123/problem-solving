1class Solution {
2
3    private boolean isSmaller(String a, String b){
4
5        if(b.length() - a.length() != 1){
6            return false;
7        }
8
9        int countDifferences = 0; 
10        int aIndex = 0, bIndex = 0;
11        
12        while(aIndex < a.length()){
13            if(a.charAt(aIndex) == b.charAt(bIndex)){
14                aIndex++; bIndex++;   
15            }
16            else {
17                countDifferences++;
18                bIndex++;
19            }
20            if(countDifferences > 1)
21                return false;
22        }
23        return countDifferences <= 1;   
24    }
25
26    public int longestStrChainUtil(String[] words, int[] memo, int index) {
27
28        if(index == 0)
29            return 1;
30        
31        if(memo[index] != -1){
32            return memo[index];
33        }
34        
35        int currentMaxLength = 1;
36        for(int i = 0 ; i < index ; i++){
37            int previousMaxLength = longestStrChainUtil(words, memo, i);
38
39            if(isSmaller(words[i], words[index])){
40                if(1 + previousMaxLength > currentMaxLength){
41                    currentMaxLength = 1 + previousMaxLength ;
42                }
43            } 
44        }
45
46        memo[index] = currentMaxLength;
47        return currentMaxLength;
48    }
49
50    public int longestStrChain(String[] words) {
51
52        int n = words.length;
53        Arrays.sort(words, 
54            (a, b) -> {
55                if(a.length() == b.length()){
56                    return a.compareTo(b);
57                }
58                return Integer.compare(a.length(), b.length());
59            }
60        );
61
62        int[] memo = new int[n];
63        Arrays.fill(memo, -1);
64        memo[0] = 1;
65        
66        longestStrChainUtil(words, memo, n - 1);
67
68
69        int maxValue = 1;
70        for(int length : memo){
71            maxValue = Math.max(maxValue, length);
72        }
73        return maxValue;
74    }
75}