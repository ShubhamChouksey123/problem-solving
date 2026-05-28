1class Solution {
2
3    private int findLongestChainUtil(int[][] pairs, int[] memo, int index){
4
5        if(index == 0)
6            return 1;
7
8        if(memo[index] != -1)
9            return memo[index];
10
11        int maxChain = 1;
12        for(int i = 0 ; i < index ; i++){
13            int prevMaxChain = findLongestChainUtil(pairs, memo, i);
14
15            if( pairs[i][1] < pairs[index][0] ){
16                maxChain = Math.max(maxChain, 1 + prevMaxChain);
17            }
18        }
19        memo[index] = maxChain;
20        return maxChain;
21    }
22
23    public int findLongestChain(int[][] pairs) {
24
25        int n = pairs.length;
26        Arrays.sort(pairs, 
27            (int[] a, int[] b) -> {
28                if(a[0] == b[0])
29                    return Integer.compare(a[1], b[1]);
30                return Integer.compare(a[0], b[0]);
31            }
32        );
33
34
35        int[] memo = new int[n];
36        Arrays.fill(memo, -1);
37        memo[0] = 1;
38
39        findLongestChainUtil(pairs, memo, n - 1);
40
41        int maxChainLength = 1;
42        for(int chainLength : memo){
43            maxChainLength = Math.max(maxChainLength, chainLength);
44        }
45        return maxChainLength;
46    }
47}