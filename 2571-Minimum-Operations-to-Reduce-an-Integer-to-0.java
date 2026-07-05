class Solution {
    
    private int minOps(int n){

        int countOnes = 0;
        for(int i = 0 ; i < 32 ; i++){
            if(((n>>i) & 1) == 1) countOnes++;
        }
        return countOnes;
    }
    
    public int minOperations(int n) {

        if(n <= 1) return n;
        if(n == 2) return 1;

        int twoSValue = 1;
        for(int i = 1 ; i < 20 ; i++){
            twoSValue = 2 * twoSValue;
            if(n == twoSValue) 
                return 1;
            if(n < twoSValue){
                break;
            }
        
        }

        int less2Power = twoSValue / 2;
        int next2Power = twoSValue;

        int a = minOperations(n - less2Power);
        int b = minOperations(next2Power - n);
        
        return 1 + Math.min(a, b);
    }
}