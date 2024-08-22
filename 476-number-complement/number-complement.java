class Solution {
    /**
        100 => 011
        101
     */
    public int findComplement(int num) {
        int ans = 0;
        int mul = 1;
        while(num > 0){
            if(num % 2 == 0){
                ans = ans + mul;
            }
            mul = mul * 2; 
            num = num >> 1;
        } 
        return ans;  
    }
}