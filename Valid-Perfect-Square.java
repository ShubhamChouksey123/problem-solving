1class Solution {
2    
3
4    /**
5        start = 1, end = 404100
6        mid = 4  
7     */
8    public boolean isPerfectSquare(int num) {
9        if(num == 1)return true;
10        
11        long n = num;
12        long start = 1; long end = num/2;
13        while(start <= end){
14            long mid = (start + end)/2;
15            long sq = mid * mid; 
16            if(sq == n){
17                return true;
18            }
19            else if( sq < n ){
20                
21                start = mid + 1;
22            }
23            else{
24                end = mid - 1;
25            }
26        }
27        
28        return false;
29    }
30}