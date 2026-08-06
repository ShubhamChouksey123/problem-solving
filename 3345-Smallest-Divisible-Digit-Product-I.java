class Solution {
    
    private int getProductOfDigits(int n) {
        
        int prod = 1;
        while(n > 0){
            prod = (n % 10) * prod;
            n = n / 10;
        } 
        return prod;       
    }

    
    public int smallestNumber(int n, int t) {
        
        while(n > 0){
            int productOrDigits = getProductOfDigits(n);
            if(productOrDigits % t == 0) break;
            n++;
        } 
        return n;       
    }
}