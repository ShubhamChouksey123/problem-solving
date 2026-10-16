class Solution {
    public int climbStairs(int n) {

        if(n <= 2) return n;
        
        int last = 2;
        int secondLast = 1;
        int val = 0;

        for(int i = 3 ; i <= n ; i++){
            val = last + secondLast;
            secondLast = last;
            last = val;
        }
        return val;
    }
}