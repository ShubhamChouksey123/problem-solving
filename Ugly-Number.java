1class Solution {
2    public boolean isUgly(int n) {
3
4        if(n <= 0){
5            return false;
6        }
7        while(n > 0){
8            if((n & 1) == 0){
9                n = n/2;
10            }
11            else if( n % 3 == 0 ){
12                n = n/3;
13            }
14            else if( n % 5 == 0){
15                n = n/5;
16            }else{
17                break;
18            }
19        }
20
21        if(n > 1)
22            return false;
23        return true;
24    }
25}