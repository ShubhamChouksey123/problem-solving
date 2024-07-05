class Solution {
    public boolean divisorGame(int n) {
        
        boolean[] canWin = new boolean[n+1];
        if(n >= 1){
            canWin[1] = false;
        }
        if(n >= 2){
            canWin[2] = true; 
        }
        if(n >= 3){
            canWin[3] = false;
        } 


        for(int i = 4 ; i <= n ; i++){
            for(int j = 1 ; j <= i/2 ; j++){
                if(i%j == 0 && !canWin[i-j]){
                    canWin[i] = true;
                }
            }
        }
        return canWin[n];
    }
}