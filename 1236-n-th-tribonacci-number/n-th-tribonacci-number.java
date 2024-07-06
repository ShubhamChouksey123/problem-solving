class Solution {
    
    public int tribonacciUtil1(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }

        return tribonacciUtil1(n-1) + tribonacciUtil1(n-2) + tribonacciUtil1(n-3);
    }
    

    public int tribonacciUtil(int n, int[] t) {
        if(n == 0){
            t[n] = 0;
            return 0;
        }
        if(n == 1 || n == 2){
            t[n] = 1;
            return 1;
        }

        if(t[n] != -1){
            return t[n];
        }

        t[n] = tribonacciUtil(n-1, t) + tribonacciUtil(n-2, t) + tribonacciUtil(n-3, t);
        return t[n];
    }
    public int tribonacci(int n) {

        // recursive
        // return tribonacciUtil1(n);

        int[] t = new int[n+1];
        Arrays.fill(t, -1);

        tribonacciUtil(n, t);
        return t[n];
    }
}