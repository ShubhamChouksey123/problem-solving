class Solution {
    public int uniqueXorTriplets(int[] nums) {
        
        int n = nums.length;
        int maxValue = nums[0];
        for(int i = 0 ; i < n ; i++){
            maxValue = Math.max(maxValue, nums[i]);
        }

        int u = 1;
        while(maxValue > 0){ 
            maxValue = maxValue >> 1;
            u = u << 1;
        } 
        u = u << 1;  
        boolean[] oneXor = new boolean[u+1];
        for(int i = 0 ; i < n ; i++){
            oneXor[nums[i]] = true;
        }

        boolean[] twoXor = new boolean[u+1];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <= u ; j++){
                if(oneXor[j]){
                    twoXor[nums[i] ^ j] = true;
                }
            }
        }

        boolean[] threeXor = new boolean[u+1];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <= u ; j++){
                if(twoXor[j]){
                    threeXor[nums[i] ^ j] = true;
                }
            }
        }

        int count = 0;
        for(int j = 0 ; j <= u ; j++){
            if(threeXor[j]){
                count++;
            }
        }
        
        return count;
    }
}