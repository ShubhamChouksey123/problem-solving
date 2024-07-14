class Solution {
    public int[] countBits(int n) {
        
        int[] bits = new int[n+1];
        
        for(int i = 1 ; i <= n ; i++){
            int count =  0;
            if(i%2 != 0){
                count++;
            }
            bits[i] = count + bits[i/2];
        }

        return bits;

    }
}