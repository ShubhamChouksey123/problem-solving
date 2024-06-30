class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int i = 0, length = flowerbed.length, count = 0 ;

        while(i <= length - 1){
            
            if(i-1 >= 0 && flowerbed[i-1] == 1){
                i++;
                continue;
            }
            if(flowerbed[i] == 1){
                i++;
                continue;
            }
            if(i+1 < length && flowerbed[i+1] == 1){
                i++;
                continue;
            }
            flowerbed[i] = 1; i++;
            count++;
        }
        
        if(count >= n){
            return true;
        }

        
        return false;
    }
}