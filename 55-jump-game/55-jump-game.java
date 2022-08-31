class Solution {
    
    
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        boolean[] isPossible = new boolean[n];
        
        isPossible[0] = true;

        
        for(int i = 0 ; i < n ; i++){
            if(isPossible[i] == true){
                 // System.out.println("i : " + i + " & j < " + Math.min(i + nums[i] + 1, n));
                 for(int j = i + 1 ; j < Math.min(i + nums[i] + 1, n)  ; j++){
                    // System.out.println("j : " + j );
                        
                    isPossible[j] = true;
                 }
            } 
        }
        
        // for(int i = 0 ; i < n ; i++){
        //    System.out.print(isPossible[i]  + " ");
        // }System.out.println("");
        
        return isPossible[n-1];
        
        
    }
}

/**
[2,3,1,1,4]
[3,2,1,0,4]
[1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0, 0, 9, 8]
*/