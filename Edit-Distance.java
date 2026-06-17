1class Solution {
2    
3    public int minDistance(String word1, String word2, int[][] memoCache, int index1, int index2) {
4        
5        if(index1 < 0 && index2 >= 0) return index2 + 1;
6        if(index2 < 0 && index1 >= 0) return index1 + 1;
7        if(index1 < 0 && index2 < 0) return 0;
8
9        if(memoCache[index1][index2] != -1) return memoCache[index1][index2];
10
11        int ans = 0;
12        if(word1.charAt(index1) == word2.charAt(index2)){
13            ans = minDistance(word1, word2, memoCache, index1 - 1, index2 - 1);
14        }
15        else{
16            ans = 1 + Math.min(
17                minDistance(word1, word2, memoCache, index1 - 1, index2 - 1),
18                Math.min(
19                    minDistance(word1, word2, memoCache, index1, index2 - 1),
20                    minDistance(word1, word2, memoCache, index1 - 1, index2)
21                )
22            );
23        }
24
25        memoCache[index1][index2] = ans;        
26        return ans;
27    }
28    
29    public int minDistance(String word1, String word2) {
30        int n = word1.length(), m = word2.length();
31        int[][] memoCache = new int[n][m];
32        for(int[] row : memoCache){
33            Arrays.fill(row, -1);
34        }
35        return minDistance(word1, word2, memoCache, n-1, m-1);
36    }
37}