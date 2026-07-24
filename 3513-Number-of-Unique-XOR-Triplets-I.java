class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;

        int largestSetBit = 0;
        for(int i = 0 ; i < 32 ; i++){
            if(( 1 & (n >> i)) == 1){
                largestSetBit = i;
            }
        }
        
        return 1 << (largestSetBit + 1);
    }
}