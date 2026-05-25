1class Solution {
2
3    private int[] memo;
4
5    private int numSquaresUtil(int n) {
6        
7        if(n <= 3){
8            return n;
9        }
10
11        if(memo[n] != -1){
12            return memo[n];
13        }
14
15
16        int count = Integer.MAX_VALUE;
17        for(int i = 2 ; i * i <= n ; i++){
18            count = Math.min( count, 1 + numSquaresUtil(n - (i*i)) );
19        }
20        memo[n] = count;
21        return count;
22    }
23    
24    public int numSquares(int n) {
25
26        if(n <= 3) return n;
27
28        memo = new int[n+1];
29        Arrays.fill(memo, -1);
30
31
32        for(int i = 0 ; i <= 3 ; i++){
33            memo[i] = i;
34        }
35        
36        return numSquaresUtil(n);
37    }
38}