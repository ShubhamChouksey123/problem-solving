1class Solution {
2    public int nthUglyNumber(int n) {
3        
4        int p2 = 0, p3 = 0, p5 = 0;
5        long[] ugly = new long[n];
6        ugly[0] = 1L;
7
8        for(int i = 1 ; i < n ; i++){
9            long p2Value = ugly[p2] * 2;
10            long p3Value = ugly[p3] * 3;
11            long p5Value = ugly[p5] * 5;
12
13            long nextUglyNumber = Math.min(p2Value, Math.min(p3Value, p5Value));
14            ugly[i] = nextUglyNumber;
15
16            if(nextUglyNumber == p2Value) p2++;
17            if(nextUglyNumber == p3Value) p3++;
18            if(nextUglyNumber == p5Value) p5++;
19
20        }
21        return (int) ugly[n-1];
22            
23    }
24}